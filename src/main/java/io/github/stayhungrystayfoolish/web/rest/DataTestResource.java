package io.github.stayhungrystayfoolish.web.rest;

import io.github.stayhungrystayfoolish.bean.ExUser;
import io.github.stayhungrystayfoolish.service.ExUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by bonismo@hotmail.com on 2018/9/4 下午5:40
 *
 * @Version: V1.0.0
 * <p>
 * Description:
 */
@RestController
@RequestMapping("/api")
public class DataTestResource {

    private final ExUserService userService;

    public DataTestResource(ExUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/mybatis/database")
    public List<ExUser> getUser() {
        return userService.getUser();
    }
}


