package org.zhl.scs.domain.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * 用户细节基础类
 * @author zsk
 * @version 1.0
 */
public class UserDetailBase implements UserDetails {
    protected String username;//用户名
    protected String password;//用户密码
    protected boolean accountNonExpired=false;//用户未过期
    protected boolean accountNonLocked=false;//
    protected boolean credentialsNonExpired=false;
    protected boolean enabled=true;

    /**
     * 获取当前用户拥有的角色信息
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    /**
     * 获取用户密码
     * @return
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * 获取用户名
     * @return
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * 当前用户是否未过期
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    /**
     * 当前用户是否未锁定
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    /**
     * 当前用户密码是否未过期
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    /**
     * 当前用户是否可用
     * @return
     */
    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
