package com.demo.helloworld;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "student")
public class Students {
    private String name;
    private Integer age;
    private String[] course;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String[] getCourse() {
        return course;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setCourse(String[] course) {
        this.course = course;
    }
}
