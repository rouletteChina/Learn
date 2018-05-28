package com.study.hystrixdashboraddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class HystrixdashboraddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixdashboraddemoApplication.class, args);
    }
}
