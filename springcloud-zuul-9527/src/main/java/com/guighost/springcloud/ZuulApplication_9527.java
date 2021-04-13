package com.guighost.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author GuiGhost
 * @date 2021/04/12
 * @className ZuulApplication_9527()
 * 描述：
 */
@SpringBootApplication
@EnableZuulProxy     //开启Zuul代理
public class ZuulApplication_9527 {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication_9527.class,args);
    }
}
