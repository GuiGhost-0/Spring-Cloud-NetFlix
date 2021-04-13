package com.guighost.springcloud;


import com.guighost.springcloud.config.ConfigBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author GuiGhost
 * @date 2021/04/07
 * @className DeptConsumer_80()
 * 描述：主启动类
 * Ribbon 和 Eureka 整合以后，客户端可以直接调用，不用去管IP地址和端口号
 */
@SpringBootApplication
@EnableEurekaClient
//指定负载均衡策略的配置类
@LoadBalancerClients(defaultConfiguration = {ConfigBean.class})
@EnableFeignClients(basePackages = {"com.guighost.springcloud"})
@ComponentScan("com.guighost.springcloud")
public class DeptConsumer_feign_80 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_feign_80.class,args);
    }
}
