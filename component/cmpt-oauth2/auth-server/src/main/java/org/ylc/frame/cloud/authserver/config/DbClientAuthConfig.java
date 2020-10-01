package org.ylc.frame.cloud.authserver.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.builders.JdbcClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

import javax.sql.DataSource;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 * <p>
 * 客户端信息存放在数据库中
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020-09-30
 */
@ConditionalOnProperty(prefix = "oauth-store", name = "client", havingValue = "db")
@Slf4j
@Configuration
@EnableAuthorizationServer
public class DbClientAuthConfig extends AbstractAuthConfig {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        log.info("客户端信息存放在数据库中");
        JdbcClientDetailsServiceBuilder jdbcBuilder = clients.jdbc(dataSource);
        jdbcBuilder.passwordEncoder(passwordEncoder);
    }
}
