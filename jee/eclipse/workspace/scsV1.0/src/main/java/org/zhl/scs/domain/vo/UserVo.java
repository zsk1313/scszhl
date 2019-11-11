package org.zhl.scs.domain.vo;

import java.io.Serializable;

/**
 * 用户Domain类
 * @author zsk
 *
 */
public class UserVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;//id主键
	private String username;//用户名称
	private String password;//密码
	private Integer roleId;//角色类
	private Integer teacherId;//该用户名的教师
	private Integer userscurityId;//用户安全认证信息类
	public UserVo() {}
	public void setId(Integer id) {
		this.id=id;
	}
	public Integer getId() {
		return id;
	}
	public void setUsername(String username) {
		this.username=username;
	}
	public String getUsername() {
		return username;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public String getPassword() {
		return password;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	public Integer getUserscurityId() {
		return userscurityId;
	}
	public void setUserscurityId(Integer userscurityId) {
		this.userscurityId = userscurityId;
	}
	@Override
	public String toString() {
		return
			"User [id="+id+", username="+username+", password="+password+", roleId="+roleId+", teacherId="+teacherId+", userscurityId="+userscurityId+"]";
	}
}