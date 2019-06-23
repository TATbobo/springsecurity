package com.tucker.securitycore.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component("securityProperties")
@ConfigurationProperties(prefix = "tucker.security")
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();

    private ValidateCodeProperties code = new ValidateCodeProperties();

    private MySocialProperties social = new MySocialProperties();

}
