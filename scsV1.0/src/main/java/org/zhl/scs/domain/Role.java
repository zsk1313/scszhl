package org.zhl.scs.domain;

import java.io.Serializable;

import java.util.List;
/**
 * 角色信息Domain
 * @author zsk
 *
 */
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;//id主键
	private String name;//角色英文名称（super，admin，student，teacher，visitor)
	private String description;//角色描述（超级管理员，管理员，学生，教师，访客）
	private List<User> users;//该角色的用户集合
	private List<Menu> menus;//该角色的资源集合
	public Role() {}
	public void setId(Integer id) {
		this.id=id;
	}
	public Integer getId() {
		return id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setDescription(String description) {
		this.description=description;
	}
	public String getDescription() {
		return description;
	}
	public void setUsers(List<User> users) {
		this.users=users;
	}
	public List<User> getUsers() {
		return users;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	@Override
	public String toString() {
		return
			"Role [id="+id+", name="+name+", description="+description+", users="+users+", menus="+menus+"]";
	}
}