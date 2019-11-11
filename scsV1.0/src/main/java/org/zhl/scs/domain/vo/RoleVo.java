package org.zhl.scs.domain.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 角色信息Domain
 * @author zsk
 *
 */
public class RoleVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;//id主键
	private String name;//角色名称（超级管理员，管理员，学生，教师，访客）
	private String description;//角色描述
	private List<Integer> users;//该角色的用户集合
	public RoleVo() {}
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
	public void setUsers(List<Integer> users) {
		this.users=users;
	}
	public List<Integer> getUsers() {
		return users;
	}
	@Override
	public String toString() {
		return
			"Role [id="+id+", name="+name+", description="+description+", users="+users+"]";
	}
}