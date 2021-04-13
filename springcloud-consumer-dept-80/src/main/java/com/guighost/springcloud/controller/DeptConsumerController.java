package com.guighost.springcloud.controller;

import com.guighost.springcloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author GuiGhost
 * @date 2021/04/07
 * @className DeptConsumerController()
 * 描述：
 */
@RestController
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT" ,fallbackFactory = DeptConsumerControllerFallbackFactory.class)
public class DeptConsumerController {
    // 消费者不应该有service层
    /**
     * RestTemplate：里面有很多的方法供我们直接调用
     * 作用：提供多种边界访问远程http服务的方法，简单的RestFul服务模板
     * 若要使用RestTemplate，将其注册到Spring中即可
     * 核心参数：(String url,实体：Map,Class<T> responseType)
     *          请求地址        实体          返回值
     */
    @Autowired
    private RestTemplate restTemplate;

    //提供者提供的接口地址
    //private static final String REST_URL_PREFIX = "http://localhost:8001";
    // 通过Ribbon实现，这里的地址应该是一个变量，通过服务名来访问
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

    @RequestMapping("/consumer/dept/get/{deptno}")
    public Dept get(@PathVariable("deptno") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id,Dept.class);
    }

    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add",dept,Boolean.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> getAll(){
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list",List.class);
    }

}
