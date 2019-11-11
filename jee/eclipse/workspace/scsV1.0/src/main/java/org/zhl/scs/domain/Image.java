package org.zhl.scs.domain;

import java.io.Serializable;

/**
 * 照片Domain
 * @author zsk
 *
 */
public class Image implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;//id主键
	private String path;//图片路径
	private Teacher teacher;//该照片所属老师
	private Clazz clazz;//该照片所属班级
	private Student student;//该照片所属学生
	public Image() {}
	public void setId(Integer id) {
		this.id=id;
	}
	public Integer getId() {
		return id;
	}
	public void setPath(String path) {
		this.path=path;
	}
	public String getPath() {
		return path;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher=teacher;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setClazz(Clazz clazz) {
		this.clazz=clazz;
	}
	public Clazz getClazz() {
		return clazz;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return
			"Image [id="+id+", path="+path+", teacher="+teacher+", clazz="+clazz+", student="+student+"]";
	}
}