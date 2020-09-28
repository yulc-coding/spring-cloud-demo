package org.ylc.frame.cloud.authserver.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MenuMapper {

    List<String> getUserPermissions(@Param("userId") Long userId);

}