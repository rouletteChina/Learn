package com.study.eurekaclientdemo.feign;

import com.study.config.CustomFeignConfig;
import com.study.eurekaclientdemo.Police;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "service-instance", configuration = CustomFeignConfig.class)
public interface CustomFeignClient {

    @RequestLine("GET /police/{id}")
    public Police call(@Param("id") Integer id);

    @RequestLine("POST /getpolice")
    public Police getPolice(Police police);
}
