package com.zjg.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * IRule 不能写道 @ComponentScan 注解可以扫描到的地方及其子包
 * 否则我们自定义的这个配置类就会被所有的Ribbon客户端共享
 *
 * @author zjg
 * @create 2020-01-01 19:48
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule() {
        //return new RandomRule();    //Ribbon 默认是轮询，这里定义为随机
        return new MyRoundRule();   //自定义的 IRule
    }
}
