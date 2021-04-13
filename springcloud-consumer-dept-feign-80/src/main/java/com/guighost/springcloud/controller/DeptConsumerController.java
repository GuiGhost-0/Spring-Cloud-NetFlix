package com.guighost.springcloud.controller;

import com.guighost.springcloud.entity.Dept;
import com.guighost.springcloud.service.DeptClientService;
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
public class DeptConsumerController {
    @Autowired
    private DeptClientService service;

    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return this.service.addDept(dept);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return this.service.queryById(id);
    }


    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return this.service.queryAll();
    }
}
