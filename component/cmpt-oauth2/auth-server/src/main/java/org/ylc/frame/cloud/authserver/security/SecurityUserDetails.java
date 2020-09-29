package org.ylc.frame.cloud.authserver.security;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 * <p>
 * 用户信息
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020-09-29
 */
@Slf4j
@Getter
@Setter
public class SecurityUserDetails implements UserDetails {

    private Long userId;

    private String username;

    private String password;

    private List<String> permissions = Collections.emptyList();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        log.info("生成权限");
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        this.permissions.forEach(o -> authorities.add(new SimpleGrantedAuthority(o)));
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    /**
     * 是否账户未过期
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 是否账户未锁定
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 是否账户未过期
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 是否可用
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
