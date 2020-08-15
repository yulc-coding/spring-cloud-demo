package org.ylc.frame.cloud.cmptfeign.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 * <p>
 * Feign 相关配置
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020-02-10
 */
@Configuration
public class FeignConfig {

    /**
     * 配置请求失败后重试
     * <p>
     * 默认不重试： Retryer.NEVER_RETRY
     * <p>
     * 这里设置：充实间隔100毫秒，最大重试时间1秒，重试次数2次
     */
    @Bean
    public Retryer feignRetryer() {
        return new Retryer.Default(100, SECONDS.toMillis(1), 2);
    }
}
