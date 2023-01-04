package com.emse.spring.faircorp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * This is the main class of Faircorp application
 *
 * In order to run a Spring Boot application, it needs to have a class with the @SpringBootApplication annotation. 
 * This starts the Spring application as a standalone application, runs the embedded servers and loads the beans.
 * `@SpringBootApplication` annotation is used to enable three features, that is `@EnableAutoConfiguration`, `@ComponentScan` & `@Configuration`
 * It enables component scanning to scan all the sub-packages for beans.
 *
 @author: Shreyas Harinath
 */

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
public class FaircorpApplication {

	public static void main(String[] args) {
		SpringApplication.run(FaircorpApplication.class, args);
	}

}
