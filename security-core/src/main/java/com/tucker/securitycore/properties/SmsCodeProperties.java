package com.tucker.securitycore.properties;

import lombok.Data;

import java.io.Serializable;

@Data
public class SmsCodeProperties {

    private int length = 6;

    private int expireIn = 60;

    private String url = "";

}
