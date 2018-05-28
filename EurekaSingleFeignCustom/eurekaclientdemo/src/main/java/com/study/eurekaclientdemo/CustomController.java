package com.study.eurekaclientdemo;

import com.study.eurekaclientdemo.feign.CustomFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/custom")
public class CustomController {
    @Autowired
    private CustomFeignClient customFeignClient;

    @GetMapping("/router/{id}")
    public Police router(@PathVariable("id") Integer id) {
        return customFeignClient.call(id);
    }

    @GetMapping("/getpolice")
    public Police getPolice(Police police) {
        return customFeignClient.getPolice(police);
    }
}
