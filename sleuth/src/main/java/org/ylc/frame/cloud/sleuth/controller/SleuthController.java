package org.ylc.frame.cloud.sleuth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020/2/24
 */
@RestController
@RequestMapping("/sleuth")
public class SleuthController {

    @GetMapping("/test")
    public String test() {
        return "success";
    }

}
