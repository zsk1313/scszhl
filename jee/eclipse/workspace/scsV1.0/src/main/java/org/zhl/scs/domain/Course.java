package org.zhl.scs.domain;

import java.io.Serializable;

import java.util.List;
/**
 * 课程Domain
 * @author zsk
 *
 */
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;//id主键
	private String name;//课程名称
	private Double score;//学分
	private String code;//课程标号
	private Integer week;//星期
	private Integer dateorder;//课程节数（1、2、3、4、5）
	private Teacher teacher;//该课程任课老师
	private List<Attenance> attenances;//该课程考勤集合
	private List<Student> students;//该课程学生集合
	public Course() {}
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
	public void setTeacher(Teacher teacher) {
		this.teacher=teacher;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setAttenances(List<Attenance> attenances) {
		this.attenances=attenances;
	}
	public List<Attenance> getAttenances() {
		return attenances;
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
			"Course [id="+id+", name="+name+", score="+score+", code="+code+", week="+week+", dateorder="+dateorder+", teacher="+teacher+", attenances="+attenances+", students="+students+"]";
	}
}