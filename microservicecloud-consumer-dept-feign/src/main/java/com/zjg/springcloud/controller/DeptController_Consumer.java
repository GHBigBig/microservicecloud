package com.zjg.springcloud.controller;

import com.zjg.springcloud.entities.Dept;
import com.zjg.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author zjg
 * @create 2019-12-29 14:23
 */
@RestController
public class DeptController_Consumer {

    @Autowired
    private DeptClientService service;

    @GetMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return this.service.get(id);
    }

    @GetMapping("/consumer/dept/list")
    public List<Dept> list() {
        return this.service.list();
    }

    @PostMapping("/consumer/dept/add")
    public Object add(Dept dept) {
        return this.service.add(dept);
    }
}
