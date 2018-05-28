package com.study.eurekaclientdemo.feign;


import com.study.config.DisabledHystrixConfig;
import com.study.eurekaclientdemo.Police;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

//三种注解说明：1.使用fallback；2.使用fallbackFactory；3.禁用单个FeignClient的Hystrix支持
//@FeignClient(name = "service-instance", fallback = TestFeignClientFallback.class)
@FeignClient(name = "service-instance", fallbackFactory = TestFeignClientFallbackFactory.class)
//@FeignClient(name = "service-instance", configuration = DisabledHystrixConfig.class, fallback = TestFeignClientFallback.class)
public interface TestFeignClient {
    @GetMapping("/police/{id}")
    public Police call(@PathVariable("id") Integer id);
}
