package com.study.eurekaclientdemo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/router/{id}")
    @HystrixCommand(fallbackMethod = "routerIdFallback")
    public Police router(@PathVariable("id") Integer id) {
        return restTemplate.getForObject("http://service-instance/police/" + id, Police.class);
    }

    public Police routerIdFallback(Integer id) {
        Police police = new Police();
        police.setId(0);
        police.setName("Hystris");

        return police;
    }
}
