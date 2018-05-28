package com.demo.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
@Configuration
public class HelloRest {
    @Autowired
    private Students students;

    @Value("${student.name}")
    private String name;

    @RequestMapping("/config")
    public Students getStudent() {
        return students;
    }

    @RequestMapping("/value")
    public String getString() {
        return name;
    }
}
