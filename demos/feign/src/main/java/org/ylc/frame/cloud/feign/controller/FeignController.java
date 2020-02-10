package org.ylc.frame.cloud.feign.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ylc.frame.cloud.feign.client.EurekaClientFeign;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020-02-10
 */
@RestController
@RequestMapping("/feign")
public class FeignController {

    private final EurekaClientFeign eurekaClientFeign;

    public FeignController(EurekaClientFeign eurekaClientFeign) {
        this.eurekaClientFeign = eurekaClientFeign;
    }

    @GetMapping("/{msg}")
    public String feignTest(@PathVariable String msg) {
        return eurekaClientFeign.feignTest(msg);
    }
}
