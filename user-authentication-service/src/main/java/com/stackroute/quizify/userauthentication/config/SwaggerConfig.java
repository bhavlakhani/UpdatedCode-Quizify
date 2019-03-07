package com.stackroute.quizify.userauthentication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ApiListingBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket productapi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.stackroute.quizify.userauthentication.controller"))
                .paths(regex("/api.*"))
                .build();

    }


    private ApiInfo metaInfo() {
        return new ApiInfoBuilder()
                .title("(user-authentication) Spring Boot REST API")
                .description("\"Spring Boot REST API for USER AUTHENTICATION\"")
                .version("1.0.0")
                .termsOfServiceUrl("Term of service")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .contact(new Contact("JASLEEN", "https://github.com/jass2795", "jasleen@gmail.com"))
                .build();
    }
}



