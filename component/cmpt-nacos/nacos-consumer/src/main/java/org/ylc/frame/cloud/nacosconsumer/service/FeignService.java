package org.ylc.frame.cloud.nacosconsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 *
 * @author yulc
 * @version 1.0.0
 * @date 2020/3/3
 */
@FeignClient(value = "nacos-discovery")
public interface FeignService {

    @GetMapping("/api/feign")
    String feignTest(@RequestParam(name = "msg") String msg);

}
