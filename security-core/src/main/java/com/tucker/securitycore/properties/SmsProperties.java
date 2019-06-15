package com.tucker.securitycore.properties;

import lombok.Data;

@Data
public class SmsProperties {

    private int length = 6;

    private int expireIn = 60;

    private String url;

}
