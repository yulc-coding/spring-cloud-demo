package org.ylc.frame.cloud.authserver.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class User {

    private Long id;

    private String name;

    private String username;

    private String password;

    private Integer createUser;

    private Date createTime;

    private Integer updateUser;

    private Date updateTime;

}