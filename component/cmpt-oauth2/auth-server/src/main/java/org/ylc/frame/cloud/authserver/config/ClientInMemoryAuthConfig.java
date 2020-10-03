package org.ylc.frame.cloud.authserver.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 * <p>
 * 客户端信息存放在内存中
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020-09-30
 */
@ConditionalOnProperty(prefix = "oauth-store", name = "client", havingValue = "memory")
@Slf4j
@Configuration
@EnableAuthorizationServer
public class ClientInMemoryAuthConfig extends AbstractAuthConfig {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        log.info("客户端信息存放在内存中");
        // 这里放在内存中
        clients.inMemory()
                // 对应请求端定义的 client-id 和 client-secret
                .withClient("client-oa")
                .secret(passwordEncoder.encode("oa-secret-8888"))
                /*
                 * authorization_code： 授权码类型
                 * implicit： 隐式授权类型
                 * password： 密码类型
                 * client_credentials： 客户端凭据类型
                 * refresh_token： 刷新令牌来获取新的令牌
                 */
                .authorizedGrantTypes("refresh_token", "authorization_code", "password")
                // token 的有效期（秒）
                .accessTokenValiditySeconds(3600)
                // 刷新Token的有效时间
                .refreshTokenValiditySeconds(86400)
                // 限制客户端访问权限，在换取的 token 的时候会带上 scope 参数，只有在 scopes 定义内的，才可以正常换取 token
                .scopes("all")
                .and()
                .withClient("client-erp")
                .secret(passwordEncoder.encode("erp-secret-8888"))
                .authorizedGrantTypes("refresh_token", "authorization_code", "password")
                .accessTokenValiditySeconds(3600)
                .scopes("all");
    }
}
