package com.guighost.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author GuiGhost
 * @date 2021/04/11
 * @className HystrixDashboard_9001()
 * 描述：
 */
@SpringBootApplication
@EnableHystrixDashboard     //开启监控页面
public class HystrixDashboard_9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboard_9001.class,args);
    }
}
