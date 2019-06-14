package com.tucker.securitycore.properties;

import lombok.Data;

@Data
public class BrowserProperties {

    private String LoginPage = "/login.html";

    private LoginType loginType = LoginType.JSON;

    private int rememberMeSeconds = 3600;
}
