package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@SpringBootApplication
public class Task11Application {

    public static void main(String[] args) {
        SpringApplication.run(Task11Application.class, args);
        System.out.println("Hello Spring Boot");
    }

    @Component
    @Endpoint(id = "check")
    public static class Check {
        private String d = "checking";

        public void setD(String st) {
            d = st;
        }

        // curl localhost:8080/actuator/check
        @ReadOperation
        public String get() {
            return d;
        }

        //curl -i -X POST -H "Content-Type: application/json" -d "{\"x\":\"val\"}" http://localhost:8080/actuator/check
        @WriteOperation
        public void write(@Valid @RequestBody String x) {
            d = x;
        }
    }
}
