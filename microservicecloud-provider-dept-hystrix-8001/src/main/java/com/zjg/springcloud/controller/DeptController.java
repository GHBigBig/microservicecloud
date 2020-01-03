package com.zjg.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zjg.springcloud.entities.Dept;
import com.zjg.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zjg
 * @create 2019-12-29 14:03
 */
@RestController
public class DeptController {
    @Autowired
    private DeptService service;

    @GetMapping(value = "/dept/get/{id}")
    //一旦调用方法失败并抛出了错误信息后，会自动调用 @HystrixCommand 标注好的 fallbackMethod 调用类中指定的方法
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = service.get(id);
        if (null == dept) {
            throw new RuntimeException("该 ID：" + id + "没有对应的信息");
        }
        return dept;
    }

    /**
     * 被消费者调用的方法抛出的异常时，此方法会被调用
     * @param id
     * @return
     */
    public Dept processHystrix_Get(@PathVariable("id") Long id) {
        Dept errorObj = new Dept();
        errorObj.setDeptno(id);
        errorObj.setDname("该 ID：" + id + " 没有对应的的信息，null--@HystrixCommand");
        errorObj.setDb_source("no this database in MySQL");

        return errorObj;
    }

}
