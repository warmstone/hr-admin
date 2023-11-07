package com.warmstone.hr.service.impl;

import com.warmstone.hr.dto.User;
import com.warmstone.hr.mapper.SysUserMapper;
import com.warmstone.hr.service.SysUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author warmstone
 * @date 2023/11/7 22:32
 * @description
 */
@Slf4j
@Service
@AllArgsConstructor
public class SysUserServiceImpl implements SysUserService {

    private final SysUserMapper sysUserMapper;

    @Override
    public User findUserByUsername(String username) {
        return sysUserMapper.findUserByUsername(username);
    }
}
