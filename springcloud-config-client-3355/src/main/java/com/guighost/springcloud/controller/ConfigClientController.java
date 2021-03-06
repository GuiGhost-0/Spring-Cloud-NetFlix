package com.guighost.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GuiGhost
 * @date 2021/04/12
 * @className ConfigClientController()
 * 描述：
 */
@RestController
public class ConfigClientController {

    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServer;
    @Value("${server.port}")
    private String port;

    @RequestMapping("/config")
    public String getConfig(){
        return applicationName + ":" + port + "/" + eurekaServer;
    }
}
