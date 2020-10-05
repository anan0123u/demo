package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

//@Configuration
//@EnableOpenApi
//public class SwaggerConfig {
//
//    /**
//     * 是否开启swagger配置，生产环境需关闭
//     */
//    @Value("${swagger.enabled}")
//    private boolean enable;
//
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.OAS_30).pathMapping("/")
//                .enable(enable)
//                .apiInfo(this.apiInfo())
//                .select() // 指定需要发布到Swagger的接口目录，不支持通配符
//                .apis(RequestHandlerSelectors.basePackage("com.example.demo.one.controller"))
//                .paths(PathSelectors.any())
//                .build()
//                // 支持的通讯协议集合
//                .protocols(this.newHashSet("https", "http"));
//    }
//
//    /**
//     * 项目信息
//     */
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder().title("Swagger Api Doc")
//                .description("SpringBoot后台接口")
////                .contact(new Contact("user", null, "xyz@qq.com"))
//                .version("Version: 1.0.0")
//                .build();
//    }
//
//    @SafeVarargs
//    private final <T> Set<T> newHashSet(T... ts) {
//        if (ts.length > 0) {
//            return new LinkedHashSet<>(Arrays.asList(ts));
//        }
//        return null;
//    }
//
//}