package org.zhl.scs.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 资源信息
 * @author zsk
 * @version 1.0
 */
public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;//资源id
    private String pattern;//资源路径规则
    private List<Role> roles;//该资源所需角色集合

    public Menu() {}

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
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
        return "Menu [id="+id+", pattern="+pattern+", roles="+roles+"]";
    }
}
