package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class Task12Application {
    static String __arg1;
    static String __arg2;

    public static void main(String[] args) {
        __arg1 = "C:/Users/Daniil/text.txt"; // args[0]
        __arg2 = "C:/Users/Daniil/hashed.hash"; // args[1]
        ShutdownController controller = new ShutdownController();
        SpringApplication.run(Task12Application.class, args);
    }

    @Bean
    public Test test() {
        return new Test();
    }
}
