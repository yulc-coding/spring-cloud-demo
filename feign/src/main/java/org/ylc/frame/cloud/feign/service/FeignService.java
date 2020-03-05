package org.ylc.frame.cloud.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.ylc.frame.cloud.feign.config.FeignConfig;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020-02-10
 */
@FeignClient(value = "api", configuration = FeignConfig.class)
public interface FeignService {

    @GetMapping("/api/feign")
    String feignTest(@RequestParam(name = "msg") String msg);
}
