package org.ylc.frame.cloud.dubbo.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ylc.frame.cloud.ProviderApiService;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020-11-13
 */
@RequestMapping("/consumer")
@RestController
public class ConsumerController {

    @Reference(version = "0.0.1")
    private ProviderApiService providerApiService;

    @GetMapping("/getProvider")
    public String getProvider() {
        return providerApiService.getProvider();
    }
}
