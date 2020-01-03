package com.zjg.springcloud.service;

import com.zjg.springcloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Feign:
 *      声明式的 Web 服务客户端
 *      接口 + 注解
 * @author zjg
 * @create 2020-01-02 12:56
 */
//@FeignClient(value = "MICROSERVICECLOUD-DEPT")    //feign 负载均衡
//指定 DeptClientServiceFallbackFactory 处理服务降级
@FeignClient(value = "MICROSERVICECLOUD-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {
    @GetMapping(value = "/dept/get/{id}")
    public Dept get(@PathVariable("id") long id);

    @GetMapping(value = "/dept/list")
    public List<Dept> list();

    @PostMapping(value = "/dept/add")
    public boolean add(Dept dept);
}
