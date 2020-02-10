package org.ylc.frame.cloud.demoapi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020-02-08
 */
@RestController
@RequestMapping("/api")
public class AipController {

    @Value("${server.port}")
    private String port;


    @GetMapping("/ribbon/{msg}")
    public String forRibbon(@PathVariable String msg) {
        System.out.printf("get message %s with ribbon", msg);
        return "from port: " + port;
    }

    @GetMapping("/feign")
    public String forFeign(@RequestParam(name = "msg") String msg) {
        System.out.printf("get message %s with feign", msg);
        return "from port: " + port;
    }

}
