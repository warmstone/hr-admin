package com.warmstone.hr.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author warmstone
 * @date 2023/11/7 22:29
 * @description
 * 表名： t_sys_user
 */
@Data
public class SysUser {

    private Long id;

    private String username;

    private String password;

    private String salt;

    private String email;

    private String phone;

    private Integer enabled;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
