package org.ylc.frame.cloud.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.ylc.frame.cloud.feign.config.FeignConfig;
import org.ylc.frame.cloud.feign.hystrix.FeignHystrix;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020-02-10
 */
@FeignClient(value = "demo-api", configuration = FeignConfig.class, fallback = FeignHystrix.class)
public interface EurekaClientFeign {

    @GetMapping("/api/feign")
    String feignTest(@RequestParam(name = "msg") String msg);
}
