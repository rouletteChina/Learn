package com.study.eurekaclientdemo;

import com.study.eurekaclientdemo.feign.TestFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class TestController {

    @Autowired
    private TestFeignClient testFeignClient;

    @GetMapping("/router/{id}")
    public Police router(@PathVariable("id") Integer id) {
        return testFeignClient.call(id);
    }

}
