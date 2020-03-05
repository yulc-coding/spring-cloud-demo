package org.ylc.frame.cloud.ribbon.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 * <p>
 * 自定义负载均衡策略
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020-03-05
 */
@Configuration
public class CustomRule {

    @Bean
    public IRule myRule() {
        // 随机方式
        return new RandomRule();
    }
}
