package org.zhl.scs.domain.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 课程Domain
 * @author zsk
 *
 */
public class CourseVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;//id主键
	private String name;//课程名称
	private Double score;//学分
	private String code;//课程标号
	private Integer week;//星期
	private Integer dateorder;//课程节数（1、2、3、4、5）
	private Integer teacher;//该课程任课老师
	private List<Integer> attenanceIds;//该课程考勤集合
	private List<Integer> studentIds;//该课程学生集合
	public CourseVo() {}
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
	public void setScore(Double score) {
		this.score=score;
	}
	public Double getScore() {
		return score;
	}
	public void setCode(String code) {
		this.code=code;
	}
	public String getCode() {
		return code;
	}
	public void setWeek(Integer week) {
		this.week=week;
	}
	public Integer getWeek() {
		return week;
	}
	public void setDateorder(Integer dateorder) {
		this.dateorder=dateorder;
	}
	public Integer getDateorder() {
		return dateorder;
	}
	public void setTeacher(Integer teacher) {
		this.teacher=teacher;
	}
	public Integer getTeacher() {
		return teacher;
	}
	public List<Integer> getAttenanceIds() {
		return attenanceIds;
	}
	public void setAttenanceIds(List<Integer> attenanceIds) {
		this.attenanceIds = attenanceIds;
	}
	public List<Integer> getStudentIds() {
		return studentIds;
	}
	public void setStudentIds(List<Integer> studentIds) {
		this.studentIds = studentIds;
	}
	@Override
	public String toString() {
		return
			"Course [id="+id+", name="+name+", score="+score+", code="+code+", week="+week+", dateorder="+dateorder+", teacher="+teacher+", attenanceIds="+attenanceIds+", studentIds="+studentIds+"]";
	}
}