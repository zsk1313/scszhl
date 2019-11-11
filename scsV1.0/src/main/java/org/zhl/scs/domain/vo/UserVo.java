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
	private Integer role;//角色类
	private Integer teacher;//该用户名的教师
	private Integer userscurity;//用户安全认证信息类
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
	public void setRole(Integer role) {
		this.role=role;
	}
	public Integer getRole() {
		return role;
	}
	public void setTeacher(Integer teacher) {
		this.teacher=teacher;
	}
	public Integer getTeacher() {
		return teacher;
	}
	public Integer getUserscurity() {
		return userscurity;
	}
	public void setUserscurity(Integer userscurity) {
		this.userscurity = userscurity;
	}
	@Override
	public String toString() {
		return
			"User [id="+id+", username="+username+", password="+password+", role="+role+", teacher="+teacher+", userscurity="+userscurity+"]";
	}
}