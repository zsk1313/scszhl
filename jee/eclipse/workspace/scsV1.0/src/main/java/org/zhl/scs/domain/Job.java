package org.zhl.scs.domain;

import java.io.Serializable;

import java.util.List;
/**
 * 职位Domain
 * @author zsk
 *
 */
public class Job implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;//
	private String name;//
	private List<Teacher> teachers;//
	public Job() {}
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
	public void setTeachers(List<Teacher> teachers) {
		this.teachers=teachers;
	}
	public List<Teacher> getTeachers() {
		return teachers;
	}
	@Override
	public String toString() {
		return
			"Job [id="+id+", name="+name+", teachers="+teachers+"]";
	}
}