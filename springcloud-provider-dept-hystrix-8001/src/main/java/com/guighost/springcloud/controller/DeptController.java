package com.guighost.springcloud.controller;

import com.guighost.springcloud.entity.Dept;
import com.guighost.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @GetMapping("/dept/get/{deptno}")
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public Dept get(@PathVariable("deptno") Long id){
        Dept dept = deptService.getById(id);
        if (dept == null){
            throw new RuntimeException("id" + id + "该用户不存在，或者信息无法找到");
        }
        return dept;
    }

    //备选方案
    public Dept hystrixGet(@PathVariable("deptno") Long id){
        return new Dept()
                .setDeptno(id)
                .setDname("id=> " + id + " 没有对应的信息，为NULL——@Hystrix")
                .setDb_source("not this database in MySQL");
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
