package com.emse.spring.faircorp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;
import com.emse.spring.faircorp.hello.ConsoleGreetingService;
import com.emse.spring.faircorp.hello.GreetingService;

@Configuration
public class FaircorpApplicationConfig {
    @Bean
    public CommandLineRunner greetingCommandLine() {
        GreetingService greetingService = new ConsoleGreetingService();
        return args -> {
            greetingService.greet("Spring");
        };
    }
}