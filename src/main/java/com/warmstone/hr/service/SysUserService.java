package com.warmstone.hr.service;

import com.warmstone.hr.dto.User;

/**
 * @author warmstone
 * @date 2023/11/7 22:32
 * @description
 */
public interface SysUserService {

    User findUserByUsername(String username);
}
