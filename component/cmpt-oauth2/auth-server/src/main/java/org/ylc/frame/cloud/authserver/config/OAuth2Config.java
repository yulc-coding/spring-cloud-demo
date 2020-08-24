package org.ylc.frame.cloud.authserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020/6/15
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private UserDetailsService securityUserDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        // 调用此方法才能支持 password 模式
        endpoints.authenticationManager(authenticationManager)
                // 设置用户验证服务
                .userDetailsService(securityUserDetailsService)
                // 指定 token 的存储方式
                .tokenStore(tokenStore);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        // 允许客户端访问OAuth2授权接口，否则请求Token时会返回401
        security.allowFormAuthenticationForClients();
        // 校验Token的接口
        security.checkTokenAccess("isAuthenticated()");
        // 获取token的接口
        security.tokenKeyAccess("generatorToken()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 这里放在内存中
        clients.inMemory()
                // 对应请求端定义的 client-id 和 client-secret
                .withClient("order-client")
                .secret(passwordEncoder.encode("order-secret-8888"))
                .authorizedGrantTypes("refresh_token", "authorization_code", "password")
                // token 的有效期
                .accessTokenValiditySeconds(3600)
                // 限制客户端访问权限
                .scopes("all")
                .and()
                .withClient("user-client")
                .secret(passwordEncoder.encode("user-secret-8888"))
                .authorizedGrantTypes("refresh_token", "authorization_code", "password")
                .accessTokenValiditySeconds(3600)
                .scopes("all");

    }
}
