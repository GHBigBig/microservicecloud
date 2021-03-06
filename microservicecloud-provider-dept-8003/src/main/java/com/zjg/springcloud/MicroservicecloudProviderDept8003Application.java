package com.zjg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient     //本服务启动后会自动注册进 eureka 服务中
@EnableDiscoveryClient  //服务发现，相当于提供了对外暴露此服务的端口
public class MicroservicecloudProviderDept8003Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicecloudProviderDept8003Application.class, args);
    }

}
