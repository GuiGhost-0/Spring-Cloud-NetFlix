package com.guighost.springcloud.service;

import com.guighost.springcloud.entity.Dept;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author GuiGhost
 * @date 2021/04/11
 * @className DeptConsumerControllerFallbackFactory()
 * 描述：服务降级
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {
    @Override
    public DeptClientService create(Throwable cause) {
        return new DeptClientService(){
            @Override
            public Dept queryById(Long id) {
                return new Dept()
                        .setDeptno(id)
                        .setDname("id=>" + id + "没有对应的信息，客户端提供降级信息，该服务已关闭")
                        .setDb_source("无数据");
            }

            @Override
            public List<Dept> queryAll() {
                return null;
            }

            @Override
            public boolean addDept(Dept dept) {
                return false;
            }

        };
    }
}
