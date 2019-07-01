package com.tucker.securitybrowser.config;


import org.springframework.context.annotation.Configuration;

@Configuration
public class BrowserSecurityBeanConfig {

   /* @Autowired
    private SecurityProperties securityProperties;*/

    /*@Bean
    @ConditionalOnMissingBean(LogoutSuccessHandler.class)
    public LogoutSuccessHandler logoutSuccessHandler(){
        return new BrowserLogoutSuccessHandler(securityProperties.getBrowser().getLogoutPage());
    }*/
}
