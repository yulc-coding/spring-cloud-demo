package org.ylc.frame.cloud.ribbon.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 * <p>
 * 配置负载均衡
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020-02-08
 */
@Configuration
public class RibbonConfig {

    /**
     * 通过RestTemplate来进行通信
     * 注解:@LoadBalanced 开启负载均衡
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * 指定负载策略，默认为轮询：RoundRobinRule
     * RoundRobinRule 轮询，默认
     * RandomRule     随机
     * AvailabilityFilteringRule 按性能来选取。
     * WeightedResponseTimeRule  根据平均响应时间来计算所有服务的权重
     * RetryRule
     * ZoneAvoidanceRule
     * ...
     */
    @Bean
    public IRule myRule() {
        // 随机方式
        // return new RandomRule();

        // 先按照轮询方式获取服务，则在指定的时间内某个实例连续访问失败，则下次轮序时会跳过该实例。
        return new RetryRule();
    }

}
