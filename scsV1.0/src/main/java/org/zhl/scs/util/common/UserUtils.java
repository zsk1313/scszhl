package org.zhl.scs.util.common;

import org.springframework.security.core.context.SecurityContextHolder;
import org.zhl.scs.domain.User;

/**
 * 用户工具类
 * @author zsk
 * @version 1.0
 * Create on 2019/11/17
 */
public class UserUtils {
    /**
     * 获取当前用户信息
     * @return 当前用户信息
     */
    public static User getCurrentUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
