package org.ylc.frame.cloud.authserver.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 * <p>
 * JWT方式生成Token
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020-09-30
 */
@ConditionalOnProperty(prefix = "oauth-store", name = "token", havingValue = "jwt")
@Configuration
@Slf4j
public class JwtTokenConfig {

    @Bean
    public TokenStore tokenStore() {
        log.info("使用JWT生成Token");
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
        // 用于签名
        accessTokenConverter.setSigningKey("JWT-SIGNINT-KEY");
        return accessTokenConverter;
    }

}
