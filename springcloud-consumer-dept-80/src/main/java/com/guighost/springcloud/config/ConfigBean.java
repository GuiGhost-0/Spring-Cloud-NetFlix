package com.guighost.springcloud.config;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

/**
 * @author GuiGhost
 * @date 2021/04/07
 * @className ConfigBean()
 * 描述：@Configuration    ——  相当于spring中的applicationContext.xml
 */
@Configuration
public class ConfigBean {

    /**
     * 配置负载均衡
     * @LoadBalance 注解
     * 这里是通过RestTemplate来获取提供者提供的服务的
     * 所以在RestTemplate上面加上@LoadBalance即可
     * IRule一个用负载均衡实现的接口
     * 它的实现类：
     *
     */
    @Bean
    @LoadBalanced//开启负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    //负载均衡算法之间切换
    @Bean
    public ReactorLoadBalancer<ServiceInstance> randomLoadBalancer(Environment environment,
                                                            LoadBalancerClientFactory loadBalancerClientFactory) {
        String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
        return new RandomLoadBalancer(loadBalancerClientFactory
                .getLazyProvider(name, ServiceInstanceListSupplier.class),
                name);
    }


}
