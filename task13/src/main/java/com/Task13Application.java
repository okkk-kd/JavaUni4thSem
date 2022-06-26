package com;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Task13Application {

    public static void main(String[] args) {
        SpringApplication.run(Task13Application.class, args);
    }

    @Component
    public static class Student {
        @Value("${program.student.name}")
        private String name;
        @Value("${program.student.last_name}")
        private String lastname;
        @Value("${program.student.group}")
        private String group;

        @PostConstruct
        public void a() {
            System.out.println(name + ' ' + lastname + ' ' + group);
        }
    }
}
