package org.ylc.frame.cloud.ribbon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020-02-08
 */
@RestController
@RequestMapping("/ribbon")
public class RibbonController {

    private final RestTemplate restTemplate;

    public RibbonController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/request/{msg}")
    public String forRequest(@PathVariable String msg) {
        return restTemplate.getForObject("http://demo-api/api/ribbon/" + msg, String.class);
    }

}
