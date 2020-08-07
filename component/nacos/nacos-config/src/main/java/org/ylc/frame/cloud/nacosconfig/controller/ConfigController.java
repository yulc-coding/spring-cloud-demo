package org.ylc.frame.cloud.nacosconfig.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020/3/3
 */
@RestController
@RefreshScope
public class ConfigController {

    @Value("${env}")
    private String env;

    @Value("${user.name}")
    private String name;

    @Value("${user.age}")
    private Integer age;

    @GetMapping("/show")
    public String showConfig() {

        return String.format("in [%s] environment, user name: [%s], age: [%s]", env, name, age);
    }

}
