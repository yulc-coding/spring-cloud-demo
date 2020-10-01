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
 * 配置
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

}