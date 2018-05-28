package com.study.eurekaclientdemo;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.study.config.CustomRibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
//此方法加载自定义RibbonConfig，如自定义文件在ApplicationMain所在package及sub package中，所有spring.application.name都使用自定义策略。
//@RibbonClient(name = "service-instance", configuration = CustomRibbonConfig.class)

//此方法加载自定义RibbonConfig，自定义文件可在ApplicationMain所在package及sub package中，，可用在个别自定义方式。（推荐）
@RibbonClient(name = "service-instance", configuration = CustomExcludeRibbonConfig.class)
@ComponentScan(excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeFromComponentScan.class) })
public class EurekaclientdemoApplication {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

//    简单配置，指定IRule ribbonRule()实现类，所有使用RestTemplate使用指定的Ribbon策略。
//    使用简单配置要去掉@RibbonClient策略，@RibbonClient策略会覆盖此策略
//    @Bean
//    public IRule ribbonRule() {
//        return new RandomRule();
//    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaclientdemoApplication.class, args);
    }
}
