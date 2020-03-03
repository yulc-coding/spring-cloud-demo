package org.ylc.frame.cloud.nacosdiscovery.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 * <p>
 * 对外接口
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020/2/28
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/request/{msg}")
    public String request(@PathVariable String msg) {
        System.out.println("get message：" + msg);
        return "from port: " + port;
    }

    @GetMapping("/restTemplate/{msg}")
    public String forRestTemplate(@PathVariable String msg) {
        System.out.printf("get message %s with ribbon\n", msg);
        return "[restTemplate] from port: " + port;
    }

    @GetMapping("/feign")
    public String forFeign(@RequestParam(name = "msg") String msg) {
        System.out.printf("get message %s with feign\n", msg);
        return "[feign] from port: " + port;
    }

}
