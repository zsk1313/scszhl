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
	private Integer teacherId;//该照片所属老师
	private Integer clazzId;//该照片所属班级
	private Integer studentId;//该照片所属学生
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
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	public Integer getClazzId() {
		return clazzId;
	}
	public void setClazzId(Integer clazzId) {
		this.clazzId = clazzId;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	@Override
	public String toString() {
		return
			"Image [id="+id+", path="+path+", teacherId="+teacherId+", clazzId="+clazzId+", studentId="+studentId+"]";
	}
}