package com.guighost.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author GuiGhost
 * @date 2021/04/07
 * @className EurekaServer_7001()
 * 描述：主启动类
 */
// 启动之后，访问http://localhost:7001/
@SpringBootApplication
@EnableEurekaServer     //@EnableEurekaServer   服务端的启动类，可以接受别人注册进来
public class EurekaServer_7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_7002.class,args);
    }
}
