package com.zjg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //EurekaServer 服务器启动类，接受其它微服务注册进来
public class MicroservicecloudEureka7001Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicecloudEureka7001Application.class, args);
    }

}
