package com.tucker.securitydemo.controller;


import com.tucker.securitydemo.entity.User;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController()
@RequestMapping("/test")
public class TestController {

    @GetMapping("/user")
    public User getUser(){
        User user = new User();
        user.setName("a");
        return user;
    }
    /*@PostMapping
    public User creat(@Valid @RequestBody User user,BindingResult errors){
        if(errors.hasErrors()){
            errors.getAllErrors().stream().forEach(error ->{
                System.out.println(error.getDefaultMessage());
            });
        }
        user.setName(user.getName());
        user.setId(1);
        System.out.println(user.getName());
        return user;
    }*/
}
