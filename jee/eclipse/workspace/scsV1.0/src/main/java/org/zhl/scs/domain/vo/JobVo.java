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
	private List<Integer> teacherIds;//
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
	public List<Integer> getTeacherIds() {
		return teacherIds;
	}
	public void setTeacherIds(List<Integer> teacherIds) {
		this.teacherIds = teacherIds;
	}
	@Override
	public String toString() {
		return
			"Job [id="+id+", name="+name+", teacherIds="+teacherIds+"]";
	}
}