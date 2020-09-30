package org.ylc.frame.cloud.authserver.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020/6/15
 */
@ConditionalOnProperty(prefix = "oauth-store", name = "token", havingValue = "redis")
@Configuration
@Slf4j
public class RedisTokenStoreConfig {

    private final RedisConnectionFactory redisConnectionFactory;

    public RedisTokenStoreConfig(RedisConnectionFactory redisConnectionFactory) {
        this.redisConnectionFactory = redisConnectionFactory;
    }

    @Bean
    public TokenStore tokenStore() {
        log.info("使用Redis存储Token");
        return new RedisTokenStore(redisConnectionFactory);
    }
}
