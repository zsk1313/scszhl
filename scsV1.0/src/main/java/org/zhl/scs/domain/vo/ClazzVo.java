package org.zhl.scs.domain.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 班级Domain
 * @author zsk
 *
 */
public class ClazzVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;//id主键
	private String clazzNum;//班级编号
	private String description;//班风描述
	private Integer teacher;//班主任
	private Integer image;//班级相册
	private List<Integer> students;//该班级学生集合
	public ClazzVo() {}
	public void setId(Integer id) {
		this.id=id;
	}
	public Integer getId() {
		return id;
	}
	public void setClazzNum(String clazzNum) {
		this.clazzNum=clazzNum;
	}
	public String getClazzNum() {
		return clazzNum;
	}
	public void setDescription(String description) {
		this.description=description;
	}
	public String getDescription() {
		return description;
	}
	public void setTeacher(Integer teacher) {
		this.teacher=teacher;
	}
	public Integer getTeacher() {
		return teacher;
	}
	public void setImage(Integer image) {
		this.image=image;
	}
	public Integer getImage() {
		return image;
	}
	public void setStudents(List<Integer> students) {
		this.students=students;
	}
	public List<Integer> getStudents() {
		return students;
	}
	@Override
	public String toString() {
		return
			"Clazz [id="+id+", clazzNum="+clazzNum+", description="+description+", teacher="+teacher+", image="+image+", students="+students+"]";
	}
}