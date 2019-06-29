package com.tucker.securitydemo.controller;

import com.tucker.securitydemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/user")
public class UserController {

    @Autowired
    private ProviderSignInUtils providerSignInUtils;

    @PostMapping("/register")
    public void regist(User user, HttpServletRequest request){
        //注册用户,不管是注册用户还是绑定用户，都会拿到一个唯一用户标识
        String userId = user.getName();
        providerSignInUtils.doPostSignUp(userId,new ServletWebRequest(request));
    }

}
