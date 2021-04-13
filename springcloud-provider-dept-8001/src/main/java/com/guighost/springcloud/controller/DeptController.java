package com.guighost.springcloud.controller;

import com.guighost.springcloud.entity.Dept;
import com.guighost.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author GuiGhost
 * @date 2021/04/07
 * @className DeptController()
 * 描述：提供RestFul服务
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    //获取一些配置的信息，得到具体的微服务
    @Autowired
    private DiscoveryClient client;

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{deptno}")
    public Dept get(@PathVariable("deptno") Long id){
        return deptService.getById(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> getAll(){
        return deptService.getAll();
    }


    //获取注册进来的微服务的一些信息
    @GetMapping("/dept/discovery")
    public Object discovery(){
        //获取微服务列表的清单
        List<String> services = client.getServices();
        System.out.println("discovery=>services:" + services);

        //得到一个具体的微服务信息，通过具体的微服务id（applicationName）
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");

        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost() + "\t" +
                    instance.getPort() + "\t" +
                    instance.getUri() + "\t" +
                    instance.getServiceId()
            );
        }

        return this.client;
    }
}
