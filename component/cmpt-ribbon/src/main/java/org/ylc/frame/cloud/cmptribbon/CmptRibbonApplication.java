package org.ylc.frame.cloud.cmptribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CmptRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmptRibbonApplication.class, args);
    }

}
