package org.ylc.frame.cloud.authserver.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Role {

    private Integer id;

    private String name;

    private String remark;

    private Integer createUser;

    private Date createTime;

    private Integer updateUser;

    private Date updateTime;

}