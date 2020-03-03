package org.ylc.frame.cloud.nacosconsumer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.ylc.frame.cloud.nacosconsumer.service.FeignService;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020/3/3
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    private final RestTemplate restTemplate;

    private final FeignService feignService;

    public ConsumerController(RestTemplate restTemplate, FeignService feignService) {
        this.restTemplate = restTemplate;
        this.feignService = feignService;
    }

    @GetMapping("/restTemplate/{msg}")
    public String restTemplateTest(@PathVariable String msg) {
        return restTemplate.getForObject("http://nacos-discovery/api/restTemplate/" + msg, String.class);
    }

    @GetMapping("/feign/{msg}")
    public String feignTest(@PathVariable String msg) {
        return feignService.feignTest(msg);
    }
}
