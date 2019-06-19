package com.tucker.securitybrowser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.tucker")
public class SecurityBrowserApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityBrowserApplication.class, args);
    }

}
