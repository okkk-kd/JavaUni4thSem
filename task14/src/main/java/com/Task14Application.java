package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Task14Application {

    public static void main(String[] args) {
        GroupController control = new GroupController();
        StudentController stControl = new StudentController();
        HomeController home = new HomeController();
        SpringApplication.run(Task14Application.class, args);
    }

}
