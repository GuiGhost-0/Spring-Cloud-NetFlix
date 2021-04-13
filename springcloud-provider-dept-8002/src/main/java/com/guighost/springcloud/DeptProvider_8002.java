package com.guighost.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author GuiGhost
 * @date 2021/04/07
 * @className DeptProvider_8001()
 * 描述：主启动类
 */
@SpringBootApplication
@EnableEurekaClient     //该注解作用是：在服务启动后，自动注册到Eureka中
@EnableDiscoveryClient  //服务发现
public class DeptProvider_8002 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_8002.class,args);
    }
}
