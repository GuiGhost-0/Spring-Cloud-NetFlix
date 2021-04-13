package com.guighost.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author GuiGhost
 * @date 2021/04/12
 * @className ConfigServer_3344()
 * 描述：
 */
@SpringBootApplication
@EnableConfigServer     //开启config服务
public class ConfigServer_3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServer_3344.class,args);
    }
}
