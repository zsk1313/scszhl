package org.zhl.scs.domain.vo;

import org.zhl.scs.domain.Role;

import java.util.List;

/**
 * 资源信息vo类
 * @author zsk
 * @version 1.0
 */
public class MenuVo {
    private Integer id;//资源id
    private String pattern;//资源路径规则
    private List<Integer> roleIds;//该资源所需角色id集合

    public List<Integer> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Integer> roleIds) {
        this.roleIds = roleIds;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public String toString(){
        return "Menu [id="+id+", pattern="+pattern+", roleIds="+roleIds+"]";
    }
}
