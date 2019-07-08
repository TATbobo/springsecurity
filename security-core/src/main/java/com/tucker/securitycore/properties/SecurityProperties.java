package com.tucker.securitycore.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "tucker.security")
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();

    private ValidateCodeProperties code = new ValidateCodeProperties();

    private MySocialProperties social = new MySocialProperties();

    private OAuth2Properties oauth2 = new OAuth2Properties();
}
