package org.ylc.frame.cloud.authserver.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.Set;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 * <p>
 * 客户端信息
 *
 * @author YuLc
 * @since 1.0
 */
@Getter
@Setter
public class OauthClientDetail {

    /**
     * 客户端ID
     */
    private String clientId;

    /**
     * 客户端秘钥
     */
    private String clientSecret;

    /**
     * 客户端授权范围
     */
    private Set<String> scope = Collections.emptySet();

    /**
     * 客户端授权类型
     */
    private Set<String> authorizedGrantTypes = Collections.emptySet();

    /**
     * token 的有效期（秒）
     */
    private Integer accessTokenValiditySeconds;

    /**
     * 刷新Token的有效时间（秒）
     */
    private Integer refreshTokenValiditySeconds;

}
