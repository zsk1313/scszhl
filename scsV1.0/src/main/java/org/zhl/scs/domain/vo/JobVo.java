package org.zhl.scs.domain.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 职位Domain
 * @author zsk
 *
 */
public class JobVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;//
	private String name;//
	private List<Integer> teachers;//
	public JobVo() {}
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
	public void setTeachers(List<Integer> teachers) {
		this.teachers=teachers;
	}
	public List<Integer> getTeachers() {
		return teachers;
	}
	@Override
	public String toString() {
		return
			"Job [id="+id+", name="+name+", teachers="+teachers+"]";
	}
}