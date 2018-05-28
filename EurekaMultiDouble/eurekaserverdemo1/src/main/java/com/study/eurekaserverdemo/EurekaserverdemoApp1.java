package com.study.eurekaserverdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaserverdemoApp1 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaserverdemoApp1.class, args);
    }
}
