package com.warmstone.hr.dto;

import cn.hutool.core.collection.CollectionUtil;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @author warmstone
 * @date 2023/11/7 22:15
 * @description
 */
public class User implements UserDetails {

    /**
     * 主键
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 账户是否过期
     */
    private boolean isAccountNonExpired;

    /**
     * 账户是否被锁定
     */
    private boolean isAccountNonLocked;

    /**
     * 密码是否过期
     */
    private boolean isCredentialsNonExpired;

    /**
     * 账户是否可用
     */
    private boolean isEnabled;

    /**
     * 角色
     */
    private List<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (CollectionUtil.isEmpty(roles)) {
            return AuthorityUtils.NO_AUTHORITIES;
        }
        String[] roleArray = roles.stream().map(Role::getRoleCode).toArray(String[]::new);
        return AuthorityUtils.createAuthorityList(roleArray);
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Role> getRoles() {
        return roles;
    }
}
