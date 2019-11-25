package org.zhl.scs.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 用户Domain类
 * @author zsk
 */
@JsonIgnoreProperties(value = {"handler"})
public class User implements Serializable, UserDetails {

	private static final long serialVersionUID = 1L;

	private Integer id;//用户id
	private String username;//用户名
	private String password;//用户密码
	private Boolean enable;//账户可用
	private Boolean locked;//账户锁定
	private List<Role> roles;;//角色类
	private Teacher teacher;//该用户名的教师
	private Student student;//该用户名的学生
	private Userscurity userscurity;//用户安全认证信息类

	public User() {}

	/**
	 * 获取当前用户拥有的角色信息
	 * @return 用户拥有的角色信息
	 */
	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return authorities;
	}
	/**
	 * 获取用户密码
	 * @return password
	 */
	@JsonIgnore
	@Override
	public String getPassword() {
		return password;
	}
	/**
	 * 获取用户名
	 * @return username
	 */
	@Override
	public String getUsername() {
		return username;
	}
	/**
	 * 当前用户是否未过期
	 * @return accountNonExpired
	 */
	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	/**
	 * 当前用户是否未锁定
	 * @return accountNonLocked
	 */
	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return !locked;
	}
	/**
	 * 当前用户密码是否未过期
	 * @return credentialsNonExpired
	 */
	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	/**
	 * 当前用户是否可用
	 * @return enabled
	 */
	@Override
	public boolean isEnabled() {
		return enable!=null?enable:true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public Boolean getEnable() {
		return enable;
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Userscurity getUserscurity() {
		return userscurity;
	}

	public void setUserscurity(Userscurity userscurity) {
		this.userscurity = userscurity;
	}

	@Override
	public String toString() {
		return
				"User [id=" + id + ", username=" + username + ", password=" + password +", locked="+locked+", enable="+enable+ ", roles=" + roles + ", teacher=" + teacher + ", student="+student+", userscurity=" + userscurity + "]";
	}
}