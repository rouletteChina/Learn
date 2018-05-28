package com.study.eurekaclientdemo.feign;

import com.study.eurekaclientdemo.Police;
import org.springframework.stereotype.Component;

@Component
public class TestFeignClientFallback implements TestFeignClient {
    @Override
    public Police call(Integer id) {
        Police police = new Police();
        police.setId(0);
        police.setName("Hystrix");

        return police;
    }
}
