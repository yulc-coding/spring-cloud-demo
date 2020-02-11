package org.ylc.frame.cloud.ribbon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ylc.frame.cloud.ribbon.service.RibbonService;

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

    private final RibbonService ribbonService;

    public RibbonController(RibbonService ribbonService) {
        this.ribbonService = ribbonService;
    }

    @GetMapping("/restTemplate/{msg}")
    public String restTemplateTest(@PathVariable String msg) {
        return ribbonService.restTemplateTest(msg);
    }

    @GetMapping("/loadBalancer")
    public String loadBalancerTest() {
        return ribbonService.loadBalancerTest();
    }
}
