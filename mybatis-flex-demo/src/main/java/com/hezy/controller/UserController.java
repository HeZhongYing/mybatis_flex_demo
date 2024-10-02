package com.hezy.controller;

import com.hezy.mapper.UserMapper;
import com.hezy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/getUser/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        return userMapper.selectOneById(id);
    }
}
