package com.example.nav;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class NavApplication {
    public static void main(String[] args) {
        SpringApplication.run(NavApplication.class, args);
    }
}
