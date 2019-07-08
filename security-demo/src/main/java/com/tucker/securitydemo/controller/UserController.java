package com.tucker.securitydemo.controller;

import com.tucker.securitycore.properties.SecurityProperties;
import com.tucker.securitydemo.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ProviderSignInUtils providerSignInUtils;

    @Autowired
    private SecurityProperties securityProperties;

    @PostMapping("/register")
    public void regist(User user, HttpServletRequest request){
        //注册用户,不管是注册用户还是绑定用户，都会拿到一个唯一用户标识
        String userId = user.getName();
        providerSignInUtils.doPostSignUp(userId,new ServletWebRequest(request));
    }

    @GetMapping("/me")
    public Object getCurrentUser(/*@AuthenticationPrincipal UserDetails user*/Authentication user,HttpServletRequest request) throws Exception {

        String header = request.getHeader("Authorization");
        String token = StringUtils.substringAfter(header,"bearer");
        Claims claims = Jwts.parser().setSigningKey(securityProperties.getOauth2().getJwtSigningKey().getBytes("UTF-8"))
                .parseClaimsJws(token).getBody();

        String admin = (String)claims.get("admin");

        System.out.println("-------->"+admin);

        return user;
    }

}
