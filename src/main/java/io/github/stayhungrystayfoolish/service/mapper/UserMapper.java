package io.github.stayhungrystayfoolish.service.mapper;

import io.github.stayhungrystayfoolish.domain.Authority;
import io.github.stayhungrystayfoolish.domain.JhiDepartment;
import io.github.stayhungrystayfoolish.domain.User;
import io.github.stayhungrystayfoolish.service.dto.UserDTO;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Mapper for the entity User and its DTO called UserDTO.
 *
 * Normal mappers are generated using MapStruct, this one is hand-coded as MapStruct
 * support is still in beta, and requires a manual step with an IDE.
 */
@Service
public class UserMapper {

    public UserDTO userToUserDTO(User user) {
        return new UserDTO(user);
    }

    public List<UserDTO> usersToUserDTOs(List<User> users) {
        return users.stream()
            .filter(Objects::nonNull)
            .map(this::userToUserDTO)
            .collect(Collectors.toList());
    }

    public User userDTOToUser(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        } else {
            User user = new User();
            user.setId(userDTO.getId());
            user.setLogin(userDTO.getLogin());
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            user.setEmail(userDTO.getEmail());
            user.setImageUrl(userDTO.getImageUrl());
            user.setActivated(userDTO.isActivated());
            user.setLangKey(userDTO.getLangKey());
            Set<JhiDepartment> departments = this.authoritiesFromStrings(userDTO.getDepartments());
            if (departments != null) {
                user.setDepartments(departments);
            }
            return user;
        }
    }

    public List<User> userDTOsToUsers(List<UserDTO> userDTOs) {
        return userDTOs.stream()
            .filter(Objects::nonNull)
            .map(this::userDTOToUser)
            .collect(Collectors.toList());
    }

    public User userFromId(Long id) {
        if (id == null) {
            return null;
        }
        User user = new User();
        user.setId(id);
        return user;
    }

    public Set<JhiDepartment> authoritiesFromStrings(Set<String> strings) {
        return strings.stream().map(string -> {
            JhiDepartment auth = new JhiDepartment();
            auth.setDepartmentName(string);
            return auth;
        }).collect(Collectors.toSet());
    }
}
