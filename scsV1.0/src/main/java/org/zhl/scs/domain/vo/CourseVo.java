package org.zhl.scs.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
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
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date startTime;//课程开始时间
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date   endTime;
	private String classroom;//教室
	private Integer dateorder;//课程节数（1、2、3、4、5）
	private Integer teacherId;//该课程任课老师
	private List<Integer> attenanceIds;//该课程考勤集合
	private List<Integer> studentIds;//该课程学生集合


	public CourseVo() {}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

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
    public Integer getTeacherId(){return teacherId;}
    public void setTeacherId(int teacherId){this.teacherId=teacherId;}
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
		return "CourseVo{" +
				"id=" + id +
				", name='" + name + '\'' +
				", score=" + score +
				", code='" + code + '\'' +
				", week=" + week +
				", startTime=" + startTime +
				", endTime=" + endTime +
				", classroom='" + classroom + '\'' +
				", dateorder=" + dateorder +
				", teacherId=" + teacherId +
				", attenanceIds=" + attenanceIds +
				", studentIds=" + studentIds +
				'}';
	}
}