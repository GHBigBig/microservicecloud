package com.zjg.springcloud.service;

import com.zjg.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 此类用于处理客户端服务降级
 * @author zjg
 * @create 2020-01-02 16:47
 */
@Component  //注册到容器中
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept get(long id) {
                return new Dept()
                        .setDeptno(id)
                        .setDname("该 ID：" + id + " 没有对应的信息，Comsumer客户端提供的降级信息，" +
                                "此时服务 Provider 已经关闭")
                        .setDb_source("no this database in MySQL");
            }

            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public boolean add(Dept dept) {
                return false;
            }
        };
    }
}
