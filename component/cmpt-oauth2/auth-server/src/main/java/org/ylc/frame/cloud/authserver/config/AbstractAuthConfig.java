package org.ylc.frame.cloud.authserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 * <p>
 * OAuth2 配置文件
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020-09-30
 */
public abstract class AbstractAuthConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private UserDetailsService securityUserDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenStore tokenStore;

    /**
     * 用来配置授权（authorization）以及令牌（token）的访问端点和令牌服务(token services)
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        // 调用此方法才能支持 password 模式
        endpoints.authenticationManager(authenticationManager)
                // 设置用户验证服务
                .userDetailsService(securityUserDetailsService)
                // 指定 token 的存储方式
                .tokenStore(tokenStore);
    }

    /**
     * 用来配置令牌端点(Token Endpoint)的安全约束.
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        // 允许客户端访问OAuth2授权接口，否则请求Token时会返回401
        security.allowFormAuthenticationForClients()
                // 校验Token的接口 /oauth/check_token
                .checkTokenAccess("isAuthenticated()")
                // 获取token的接口 /oauth/token_key
                .tokenKeyAccess("generatorToken()");
    }

}
