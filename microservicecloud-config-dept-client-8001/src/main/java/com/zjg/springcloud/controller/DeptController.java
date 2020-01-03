package com.zjg.springcloud.controller;

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
    @Autowired
    private DiscoveryClient client; //用于服务发现，不是重点

    @PostMapping(value = "/dept/add")
    public boolean add(@RequestBody Dept dept) {
        return service.add(dept);
    }

    @GetMapping(value = "/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @GetMapping(value = "/dept/list")
    public List<Dept> list() {
        return service.list();
    }

    /**
     * 用于服务发现，不是重点
     * @return
     */
    @GetMapping(value = "/dept/discovery")
    public Object discovery() {
        List<String> list = client.getServices();
        System.out.println("***************" + list);
        List<ServiceInstance> serverList = client.getInstances("MICROSERVICECLOUD-DEPT");
        serverList.forEach((element) -> {
            System.out.println(element.getServiceId() + "\t"
                    + element.getHost() + "\t" + element.getPort() + "\t" + element.getUri());
        });
        return this.client;
    }

}
