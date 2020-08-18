package org.ylc.frame.cloud.cmptsentinel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ylc.frame.cloud.cmptsentinel.server.TestService;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 * <p>
 * 测试接口
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020-07-08
 */
@RequestMapping("/test")
@RestController
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/")
    public String sentinelTest() {
        return testService.sentinelTest();
    }
}
