package com.tucker.securitydemo.controller;


import com.tucker.securitydemo.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/user")
    public User getUser(){
        User user = new User();
        user.setName("a");
        System.out.println(user);
        return user;
    }
}
