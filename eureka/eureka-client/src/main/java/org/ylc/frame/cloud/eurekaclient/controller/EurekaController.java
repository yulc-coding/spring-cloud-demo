package org.ylc.frame.cloud.eurekaclient.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020/2/28
 */
@RestController
public class EurekaController {

    private final DiscoveryClient discoveryClient;

    public EurekaController(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("/test")
    public Object test() {
        List<String> services = discoveryClient.getServices();
        System.out.println("services:" + services);

        List<ServiceInstance> instances = discoveryClient.getInstances("eureka-client");
        for (ServiceInstance instance : instances) {
            System.out.printf("instanceId: %s, serviceId: %s, host: %s, port: %s, uri: %s",
                    instance.getInstanceId(),
                    instance.getServiceId(),
                    instance.getHost(),
                    instance.getPort(),
                    instance.getUri()
            );
        }
        return this.discoveryClient;
    }
}
