package com.study.eurekaclientdemo;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ExcludeFromComponentScan
public class CustomExcludeRibbonConfig {
    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }
}
