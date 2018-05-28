package com.study.eurekaclientdemo.feign;


import com.study.eurekaclientdemo.Police;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "service-instance")
public interface TestFeignClient {

    @GetMapping("/police/{id}")
    public Police call(@PathVariable("id") Integer id);

    @PostMapping("/getpolice")
    public Police getPolice(@RequestBody Police police);
}
