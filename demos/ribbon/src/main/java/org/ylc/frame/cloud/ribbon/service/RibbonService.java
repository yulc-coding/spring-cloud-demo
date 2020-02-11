package org.ylc.frame.cloud.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020-02-11
 */
@Service
public class RibbonService {

    private final RestTemplate restTemplate;

    private final LoadBalancerClient loadBalancerClient;

    public RibbonService(RestTemplate restTemplate, LoadBalancerClient loadBalancerClient) {
        this.restTemplate = restTemplate;
        this.loadBalancerClient = loadBalancerClient;
    }

    @HystrixCommand(fallbackMethod = "returnError")
    public String restTemplateTest(String msg) {
        return restTemplate.getForObject("http://demo-api/api/ribbon/" + msg, String.class);
    }

    /**
     * LoadBalancerClient 从 Eureka Client 获取服务注册列表信息的,并进行缓存
     * 调用choose()方法时，会更具负载策略选择一个实例
     * <p>
     * 也可以通过`ribbon.eureka.enabled=false`不从 Eureka Client 获取注册列表
     * 这时需要自己维护一份祖册列表信息
     */
    public String loadBalancerTest() {
        ServiceInstance instance = loadBalancerClient.choose("demo-api");
        return instance.getHost() + ":" + instance.getPort();
    }

    private String returnError(String msg) {
        return String.format("return Error ! get msg : %s", msg);
    }
}
