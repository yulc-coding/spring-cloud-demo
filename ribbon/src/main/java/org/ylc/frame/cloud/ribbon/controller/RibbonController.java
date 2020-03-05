package org.ylc.frame.cloud.ribbon.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020-02-08
 */
@RestController
@RequestMapping("/ribbon")
public class RibbonController {

    private final RestTemplate restTemplate;

    private final LoadBalancerClient loadBalancerClient;

    public RibbonController(RestTemplate restTemplate, LoadBalancerClient loadBalancerClient) {
        this.restTemplate = restTemplate;
        this.loadBalancerClient = loadBalancerClient;
    }

    /**
     * LoadBalancerClient 从 Eureka Client 获取服务注册列表信息的,并进行缓存
     * 调用choose()方法时，会更具负载策略选择一个实例
     */
    @GetMapping("/loadBalancer")
    public String loadBalancerTest() {
        ServiceInstance instance = loadBalancerClient.choose("api");
        return instance.getHost() + ":" + instance.getPort();
    }

    /**
     * 整合Eureka后可以直接通过微服务名称进行访问
     */
    @GetMapping("/restTemplate/{msg}")
    public String restTemplateTest(@PathVariable String msg) {
        return restTemplate.getForObject("http://api/api/restTemplate/" + msg, String.class);
    }

}
