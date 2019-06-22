package com.tucker.securitybrowser.config;


import com.tucker.securitybrowser.authentication.TuckerLogoutSuccessHandler;
import com.tucker.securitycore.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
public class BrowserSecurityBeanConfig {

   /* @Autowired
    private SecurityProperties securityProperties;*/

    /*@Bean
    @ConditionalOnMissingBean(LogoutSuccessHandler.class)
    public LogoutSuccessHandler logoutSuccessHandler(){
        return new TuckerLogoutSuccessHandler(securityProperties.getBrowser().getLogoutPage());
    }*/
}
