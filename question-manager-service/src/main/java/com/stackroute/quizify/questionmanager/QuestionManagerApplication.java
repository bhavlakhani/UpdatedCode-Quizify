package com.stackroute.quizify.questionmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/*
 * For a @SpringBootApplication to be discovery-aware, we have to include the annotation "@EnableDiscoveryClient".
 *
 * Spring Boot @SpringBootApplication annotation is used to mark a configuration class that declares one or more
 * @Bean methods and also triggers auto-configuration and component scanning. It’s same as declaring a class with
 * @Configuration, @EnableAutoConfiguration and @ComponentScan annotations.
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = "com.stackroute.quizify")
public class QuestionManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuestionManagerApplication.class, args);
    }

}

