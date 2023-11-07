package com.warmstone.hr.mapper;

import com.warmstone.hr.dto.User;

/**
 * @author warmstone
 * @date 2023/11/7 22:33
 * @description
 */
public interface SysUserMapper {

    User findUserByUsername(String username);
}
