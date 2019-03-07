package com.stackroute.quizify.userregistrationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@SpringBootApplication
@ComponentScan(basePackages = "com.stackroute.quizify")
public class UserRegistrationService {

	public static void main(String[] args) {
		SpringApplication.run(UserRegistrationService.class, args);
	}

}
