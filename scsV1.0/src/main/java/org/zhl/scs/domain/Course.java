package org.zhl.scs.domain;

import java.io.Serializable;

import java.util.Date;
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
	private String classroom;//教室
	private Integer dateorder;//课程节数（1、2、3、4、5）
	private Teacher teacher;//该课程任课老师
	private Date   start_time;//课程开始时间
	private Date   end_time;
	private List<Attenance> attenances;//该课程考勤集合
	private List<Student> students;//该课程学生集合
	public Course() {}
	public void setStart_time(Date start_time){this.start_time=start_time;}
	public Date getStart_time(){return start_time;}
	public void setEnd_time(Date end_time){this.end_time=end_time;}
	public Date getEnd_time(){return end_time;}
	public void setClassroom(String classroom){this.classroom=classroom;}
	public String getClassroom(){return classroom;}
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
	//不需要实现
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
			"Course [id="+id+", name="+name+", score="+score+", start_time="+start_time+", end_time="+end_time+", classroom="+classroom+", code="+code+", week="+week+", dateorder="+dateorder+", teacher="+teacher+", attenances="+attenances+", students="+students+"]";
	}
}