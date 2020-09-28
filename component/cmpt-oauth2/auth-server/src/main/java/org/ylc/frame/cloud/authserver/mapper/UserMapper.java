package org.ylc.frame.cloud.authserver.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.ylc.frame.cloud.authserver.entity.User;

import java.util.List;

@Component
public interface UserMapper {

    List<User> list();

    User loadUserByUsername(@Param("username") String username);
}