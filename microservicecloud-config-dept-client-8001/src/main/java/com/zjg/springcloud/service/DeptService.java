package com.zjg.springcloud.service;

import com.zjg.springcloud.entities.Dept;

import java.util.List;

/**
 * @author zjg
 * @create 2019-12-29 13:59
 */
public interface DeptService {
    boolean add(Dept dept);
    Dept get(Long id);
    List<Dept> list();
}
