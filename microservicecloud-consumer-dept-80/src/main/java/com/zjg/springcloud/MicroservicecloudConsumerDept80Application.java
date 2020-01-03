package com.zjg.springcloud;

import com.zjg.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient     //加入 eureka
//在启动改微服务的时候就能去加载我们自定义Ribbon配置类，从而使配置生效
@RibbonClient(name="MICROSERVICECLOUD-DEPT", configuration= MySelfRule.class)
public class MicroservicecloudConsumerDept80Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicecloudConsumerDept80Application.class, args);
    }

}
