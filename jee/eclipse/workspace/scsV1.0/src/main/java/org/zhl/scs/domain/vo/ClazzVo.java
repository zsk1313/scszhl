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
	private Integer teacherId;//班主任
	private Integer imageId;//班级相册
	private List<Integer> studentIds;//该班级学生集合
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
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	public Integer getImageId() {
		return imageId;
	}
	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}
	public void setStudentIds(List<Integer> studentIds) {
		this.studentIds=studentIds;
	}
	public List<Integer> getStudentIds() {
		return studentIds;
	}
	@Override
	public String toString() {
		return
			"Clazz [id="+id+", clazzNum="+clazzNum+", description="+description+", teacherId="+teacherId+", imageId="+imageId+", studentIds="+studentIds+"]";
	}
}