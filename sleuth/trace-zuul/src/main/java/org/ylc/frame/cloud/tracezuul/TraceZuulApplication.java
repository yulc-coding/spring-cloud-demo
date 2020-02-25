package org.ylc.frame.cloud.tracezuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class TraceZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(TraceZuulApplication.class, args);
    }

}
