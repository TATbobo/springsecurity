package com.tucker.securitycore.properties;

import lombok.Data;

@Data
public abstract class SocialProperties {
    private String appId;
    private String appSecret;
}