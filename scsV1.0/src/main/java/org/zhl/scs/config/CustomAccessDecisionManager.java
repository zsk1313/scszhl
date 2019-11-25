package org.zhl.scs.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * 用户权限判断管理类
 * @author zsk
 * @version 1.0
 * Create on 2019/11/14
 */
@Component
public class CustomAccessDecisionManager
        implements AccessDecisionManager {
    @Override
    public void decide(Authentication auth,
                       Object object,
                       Collection<ConfigAttribute> ca){
        Collection<? extends GrantedAuthority> auths = auth.getAuthorities();
        for (ConfigAttribute configAttribute : ca) {
            if ("ROLE_LOGIN".equals(configAttribute.getAttribute())) {
                if (auth instanceof AnonymousAuthenticationToken) {//判断是否匿名用户实例
                    throw new BadCredentialsException("未登录");
                } else
                    return;
            }
            for (GrantedAuthority authority : auths) {
                if (configAttribute.getAttribute().equals(authority.getAuthority())) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("权限不足");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
