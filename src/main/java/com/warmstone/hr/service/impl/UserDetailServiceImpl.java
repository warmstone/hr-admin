package com.warmstone.hr.service.impl;

import com.warmstone.hr.dto.User;
import com.warmstone.hr.service.SysUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author warmstone
 * @date 2023/11/7 23:17
 * @description
 */
@Slf4j
@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = sysUserService.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名或者密码错误");
        }
        return user;
    }
}
