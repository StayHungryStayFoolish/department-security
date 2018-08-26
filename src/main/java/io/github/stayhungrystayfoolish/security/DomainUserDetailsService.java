package io.github.stayhungrystayfoolish.security;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import io.github.stayhungrystayfoolish.domain.Authority;
import io.github.stayhungrystayfoolish.domain.JhiDepartment;
import io.github.stayhungrystayfoolish.domain.User;
import io.github.stayhungrystayfoolish.repository.UserRepository;
import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Authenticate a user from the database.
 */
@Component("userDetailsService")
public class DomainUserDetailsService implements UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(DomainUserDetailsService.class);

    private final UserRepository userRepository;

    public DomainUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String login) {
        log.debug("Authenticating {}", login);

        if (new EmailValidator().isValid(login, null)) {
            Optional<User> userByEmailFromDatabase = userRepository.findOneWithJhiDepartmentsByEmail(login);
            return userByEmailFromDatabase.map(user -> createSpringSecurityUser(login, user))
                .orElseThrow(() -> new UsernameNotFoundException("User with email " + login + " was not found in the database"));
        }

        String lowercaseLogin = login.toLowerCase(Locale.ENGLISH);
        Optional<User> userByLoginFromDatabase = userRepository.findOneWithJhiDepartmentsByLogin(lowercaseLogin);
        return userByLoginFromDatabase.map(user -> createSpringSecurityUser(lowercaseLogin, user))
            .orElseThrow(() -> new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the database"));

    }

    private org.springframework.security.core.userdetails.User createSpringSecurityUser(String lowercaseLogin, User user) {
        if (!user.getActivated()) {
            throw new UserNotActivatedException("User " + lowercaseLogin + " was not activated");
        }
        Set<JhiDepartment> departments = user.getDepartments();
        for (JhiDepartment department : departments) {
            Set<Authority> authorities = department.getAuthorities();
            for (Authority authority : authorities) {
                String name = authority.getName();
                System.out.println("Authority"+name);
            }
        }

        List<SimpleGrantedAuthority> grantedAuthorities1 = new ArrayList<>();
        Set<JhiDepartment> departments1 = user.getDepartments();
        for (JhiDepartment department : departments1) {
            System.out.println("DEP_NAME - "+department.getDepartmentName());
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(department.getDepartmentName());
            grantedAuthorities1.add(authority);
        }
        System.out.println("SIZE -"+grantedAuthorities1.size());

        List<GrantedAuthority> grantedAuthorities = user.getDepartments().stream()
            .map(authority -> new SimpleGrantedAuthority(authority.getDepartmentName()))
            .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(user.getLogin(),
            user.getPassword(),
            grantedAuthorities);
    }
}
