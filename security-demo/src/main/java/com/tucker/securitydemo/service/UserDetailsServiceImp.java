package com.tucker.securitydemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;

@Component("userDetailsService")
public class UserDetailsServiceImp implements UserDetailsService, SocialUserDetailsService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("表单登录用户名=====" + username);
        return buildUserDetails(username);
    }

    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        logger.info("社交登录用户id=====" + userId);
        return buildUserDetails(userId);
    }

    private SocialUserDetails buildUserDetails(String userId) {
        String password = passwordEncoder.encode("123");
        //从数据库中查出用户信息
        logger.info("数据库密码====="+password);
        return new SocialUser(userId,password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
