package com.stackroute.quizify.questionmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
* Spring @Configuration annotation is part of the spring core framework.
* Spring Configuration annotation indicates that the class has @Bean definition methods.
* So Spring container can process the class and generate Spring Beans to be used in the application.
*
* The Annotation "@EnableSwagger2" Indicates that Swagger support should be enabled.
* This should be applied to a Spring java config and should have an accompanying '@Configuration' annotation.
* Loads all required beans defined in @see SpringSwaggerConfig
*
* The Annotation "@Bean" Indicates that a method produces a bean to be managed by the Spring container.
*
* The Interface "WebMvcConfigurer" Defines callback methods to customize the Java-based configuration for Spring MVC.
*/

@Configuration
@EnableSwagger2
public class SwaggerConfiguration implements WebMvcConfigurer
{
    @Bean
    public Docket apiDocket() {

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.stackroute.quizify.questionmanager.controller"))
                .paths(PathSelectors.any())
                .build();
    }

}
