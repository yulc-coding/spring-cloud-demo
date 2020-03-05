package org.ylc.frame.cloud.ribbon.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 * <p>
 * 配置负载均衡
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020-02-08
 */
@Configuration
public class RibbonConfig {

    /**
     * 通过RestTemplate来进行通信
     * 注解:@LoadBalanced 开启负载均衡
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
