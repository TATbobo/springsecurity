package com.tucker.securitycore.controller;

import com.tucker.securitycore.bean.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CoreTestController {

    @GetMapping("/test")
    public List<String> test(){
        List<String > list = new ArrayList<>();
        list.add("小明");
        list.add("二狗");
        return list;
    }

    @GetMapping("/user")
    public User getUser(){
        User user = new User();
        user.setName("猩猩");
        user.setAge(10);
        return user;
    }
}
