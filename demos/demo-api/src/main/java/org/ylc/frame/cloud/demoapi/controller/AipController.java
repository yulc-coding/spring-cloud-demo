package org.ylc.frame.cloud.demoapi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        System.out.printf("get message %s", msg);
        return "from port: " + port;
    }


}
