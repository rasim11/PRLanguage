package com.example.prlanguage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })/*For desabling the default login form*/
public class PrLanguageApplication {
    public static void main(String[] args) {SpringApplication.run(PrLanguageApplication.class, args);

    }

}
