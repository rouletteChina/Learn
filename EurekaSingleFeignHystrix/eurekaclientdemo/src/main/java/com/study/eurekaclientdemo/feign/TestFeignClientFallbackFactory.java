package com.study.eurekaclientdemo.feign;

import com.study.eurekaclientdemo.Police;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class TestFeignClientFallbackFactory implements FallbackFactory<TestFeignClient> {
    @Override
    public TestFeignClient create(Throwable throwable) {
        return new TestFeignClient(){

            @Override
            public Police call(Integer id) {
                System.out.println(throwable.getMessage());

                Police police = new Police();
                police.setId(-1);
                police.setName("Hystrix");

                return police;
            }
        };
    }
}
