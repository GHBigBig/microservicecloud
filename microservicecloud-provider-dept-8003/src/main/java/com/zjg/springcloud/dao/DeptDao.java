package com.zjg.springcloud.dao;

import com.zjg.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zjg
 * @create 2019-12-29 13:53
 */
@Mapper //必须加方便识别
public interface DeptDao {
    boolean insertDept(Dept dept);
    Dept selectById(Long id);
    List<Dept> selectAll();
}
