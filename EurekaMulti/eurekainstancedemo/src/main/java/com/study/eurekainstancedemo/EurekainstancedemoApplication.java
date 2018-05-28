package com.study.eurekainstancedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient
public class EurekainstancedemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekainstancedemoApplication.class, args);
    }
}
