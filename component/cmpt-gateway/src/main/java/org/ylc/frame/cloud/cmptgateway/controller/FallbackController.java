package org.ylc.frame.cloud.cmptgateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 * <p>
 * 服务降级
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020/2/26
 */
@RestController
public class FallbackController {

    @GetMapping("/fallback")
    public String fallback() {
        return "服务异常，请稍后再试";
    }

}
