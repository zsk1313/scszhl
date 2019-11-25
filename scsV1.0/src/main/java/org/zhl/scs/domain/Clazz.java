package org.zhl.scs.domain;

import java.io.Serializable;

import java.util.List;
/**
 * 班级Domain
 * @author zsk
 *
 */
public class Clazz implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;//id主键
	private String clazzNum;//班级编号
	private String description;//班风描述
	private Teacher teacher;//班主任
	private Image image;//班级相册
	private List<Student> students;//该班级学生集合
	public Clazz() {}
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
	public void setTeacher(Teacher teacher) {
		this.teacher=teacher;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setImage(Image image) {
		this.image=image;
	}
	public Image getImage() {
		return image;
	}
	public void setStudents(List<Student> students) {
		this.students=students;
	}
	public List<Student> getStudents() {
		return students;
	}
	@Override
	public String toString() {
		return
			"Clazz [id="+id+", clazzNum="+clazzNum+", description="+description+", teacher="+teacher+", image="+image+", students="+students+"]";
	}
}