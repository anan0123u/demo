package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/templates/index.html");
//        registry.addViewController("/b").setViewName("redirect:/templates/web/main.html");
//        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

}
