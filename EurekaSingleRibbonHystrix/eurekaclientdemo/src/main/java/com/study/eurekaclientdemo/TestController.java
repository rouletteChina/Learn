package com.study.eurekaclientdemo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/router/{id}")
    @HystrixCommand(fallbackMethod = "routerIdFallback")
//    @HystrixCommand(fallbackMethod = "stubMyService",
//            commandProperties = {
//                    @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")
//            }
//    )
//    通过上面配置可以使用Fallback方法和请求方法使用同一个线程，如果不配置commandProperties则Fallback方法使用的是隔离线程。
//    正常情况下不要配置commandProperties，抛异常时再配置。
    public Police router(@PathVariable("id") Integer id) {
        return restTemplate.getForObject("http://service-instance/police/" + id, Police.class);
    }

    public Police routerIdFallback(Integer id) {
        Police police = new Police();
        police.setId(0);
        police.setName("Hystris");

        return police;
    }

//    @GetMapping("/getpolice")
//    public Police getPolice(Police police) {
//        return restTemplate.getForObject("http://service-instance/getpolice/" + police, Police.class);
//    }
}
