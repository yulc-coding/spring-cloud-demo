package org.ylc.frame.cloud.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.ylc.frame.cloud.ribbon.config.CustomRule;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "API", configuration = CustomRule.class) // 配置自定义负载策略
public class RibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonApplication.class, args);
    }

}
