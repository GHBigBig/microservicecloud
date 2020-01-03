package com.zjg.springcloud.service;

import com.zjg.springcloud.dao.DeptDao;
import com.zjg.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
