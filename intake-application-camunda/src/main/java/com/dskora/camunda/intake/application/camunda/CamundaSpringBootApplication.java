package com.dskora.camunda.intake.application.camunda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;

@SpringBootApplication
@EnableProcessApplication
public class CamundaSpringBootApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(CamundaSpringBootApplication.class, args);
    }
}