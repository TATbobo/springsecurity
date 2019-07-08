package com.tucker.securitycore.properties;

import lombok.Data;

@Data
public class OAuth2Properties {

    private String jwtSigningKey = "tucker";

    private String storeType;

    private OAuth2ClientProperties[] clients = {};
}
