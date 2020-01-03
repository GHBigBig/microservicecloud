package com.zjg.springcloud.service.impl;

import com.zjg.springcloud.dao.DeptDao;
import com.zjg.springcloud.entities.Dept;
import com.zjg.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zjg
 * @create 2019-12-29 13:59
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;

    @Override
    public boolean add(Dept dept) {
        return deptDao.insertDept(dept);
    }

    @Override
    public Dept get(Long id) {
        return deptDao.selectById(id);
    }

    @Override
    public List<Dept> list() {
        return deptDao.selectAll();
    }
}
