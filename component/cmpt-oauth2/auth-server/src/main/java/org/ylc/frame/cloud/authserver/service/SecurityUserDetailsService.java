package org.ylc.frame.cloud.authserver.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.ylc.frame.cloud.authserver.entity.User;
import org.ylc.frame.cloud.authserver.mapper.UserMapper;
import org.ylc.frame.cloud.authserver.security.SecurityUserDetails;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020/6/15
 */
@Slf4j
@Component
public class SecurityUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsername:" + username);
        User user = userMapper.loadUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("the user is not found");
        }

        SecurityUserDetails userDetails = new SecurityUserDetails();
        userDetails.setUserId(user.getId());
        userDetails.setUsername(user.getUsername());
        userDetails.setPassword(user.getPassword());

        return userDetails;
    }

}
