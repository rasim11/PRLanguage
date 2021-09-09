package com.example.prlanguage.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class AddiotionalResourcesWebConfiguration implements WebMvcConfigurer {

    @Override
    public  void addResourceHandlers (final ResourceHandlerRegistry registry){
        registry.addResourceHandler("/img/**").addResourceLocations("file:///" + System.getProperty("user.dir") + "/src/main/media/img/");
    }
}
