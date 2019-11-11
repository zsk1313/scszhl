package org.zhl.scs.domain.vo;

import java.io.Serializable;

/**
 * 照片Domain
 * @author zsk
 *
 */
public class ImageVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;//id主键
	private String path;//图片路径
	private Integer teacher;//该照片所属老师
	private Integer clazz;//该照片所属班级
	private Integer student;//该照片所属学生
	public ImageVo() {}
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
	public void setTeacher(Integer teacher) {
		this.teacher=teacher;
	}
	public Integer getTeacher() {
		return teacher;
	}
	public void setClazz(Integer clazz) {
		this.clazz=clazz;
	}
	public Integer getClazz() {
		return clazz;
	}
	public Integer getStudent() {
		return student;
	}
	public void setStudent(Integer student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return
			"Image [id="+id+", path="+path+", teacher="+teacher+", clazz="+clazz+", student="+student+"]";
	}
}