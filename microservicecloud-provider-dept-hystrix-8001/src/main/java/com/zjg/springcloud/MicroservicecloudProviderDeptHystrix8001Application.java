package com.zjg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient     //本服务启动后会自动注册进 eureka 服务中
@EnableDiscoveryClient  //服务发现，相当于提供了对外暴露此服务的端口
@EnableCircuitBreaker   //对 hystrix 熔断机制的支持
public class MicroservicecloudProviderDeptHystrix8001Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicecloudProviderDeptHystrix8001Application.class, args);
    }

}
