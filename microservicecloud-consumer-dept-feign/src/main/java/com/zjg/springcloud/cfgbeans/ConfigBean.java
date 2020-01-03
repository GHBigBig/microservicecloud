package com.zjg.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author zjg
 * @create 2019-12-29 14:20
 */
@Configuration
public class ConfigBean {
    @Bean
    @LoadBalanced   //将 Rest 加入 Ribbon 的配置
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /*@Bean
    public IRule myRule() { //配置负载均衡策略
//        return new RoundRobinRule();  //默认的，轮询
//        return new RandomRule();    //随机
        return new RetryRule(); //演示失败
    }*/

}
