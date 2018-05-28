package com.study.eurekaclientdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
@Configuration      //@Configuration加载spring
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/router")
    public String router() {
        //service-instance是spring.application.name,即VIP（虚拟IP）
        String json = restTemplate.getForObject("http://service-instance/police/215", String.class);
        json = "通过service-instance服务获取信息：" + json;
        return json;
    }
}
