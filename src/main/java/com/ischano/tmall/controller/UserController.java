package com.ischano.tmall.controller;

import com.ischano.tmall.entiey.User;
import com.ischano.tmall.service.UserService;
import com.ischano.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public Page4Navigator<User> list(
            @RequestParam(name = "start", defaultValue = "0") int start,
            @RequestParam(name = "size", defaultValue = "5") int size) throws Exception {
        start = start < 0 ? 0 : start;
        return userService.list(start, size, 5);
    }

}
