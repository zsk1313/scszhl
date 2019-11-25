package org.zhl.scs.domain.vo;

import java.io.Serializable;
import java.util.List;

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
	private Boolean enable;//账户可用
	private Boolean locked;//账户锁定
	private Integer studentId;//该用户名的学生id
	private Integer teacherId;//该用户名的教师ud
	private Integer userscurityId;//用户安全认证信息类ud
	private List<Integer> roleIds;//该用户的角色id集合
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

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
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

	public List<Integer> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<Integer> roleIds) {
		this.roleIds = roleIds;
	}

	@Override
	public String toString() {
		return
			"User [id="+id+", username="+username+", password="+password+", enable="+enable+", locked="+locked+", studentId="+studentId+", teacherId="+teacherId+", userscurityId="+userscurityId+", roleIds="+roleIds+"]";
	}
}