package com.tucker.securitycore.social;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Component;

@Component
public class ConnectionSinUp implements ConnectionSignUp {
    /**
     * 默认为QQ用户以用户名创建用户
     * @param connection
     * @return
     */
    @Override
    public String execute(Connection<?> connection) {
        return connection.getDisplayName();
    }
}
