package org.zhl.scs.domain;

import java.io.Serializable;

import java.util.Date;

import java.util.List;
/**
 * 考勤Domain
 * @author zsk
 *
 */
public class Attenance implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;//id主键
	private Date date;//日期
	private Integer total;//应到人数
	private Integer actual;//实到人数
	private String note;//备注
	private Course course;//课程
	private List<AttendanceDetail> attendanceDetails;//考勤信息条集合
	public Attenance() {}
	public void setId(Integer id) {
		this.id=id;
	}
	public Integer getId() {
		return id;
	}
	public void setDate(Date date) {
		this.date=date;
	}
	public Date getDate() {
		return date;
	}
	public void setTotal(Integer total) {
		this.total=total;
	}
	public Integer getTotal() {
		return total;
	}
	public void setActual(Integer actual) {
		this.actual=actual;
	}
	public Integer getActual() {
		return actual;
	}
	public void setNote(String note) {
		this.note=note;
	}
	public String getNote() {
		return note;
	}
	public void setCourse(Course course) {
		this.course=course;
	}
	public Course getCourse() {
		return course;
	}
	public void setAttendanceDetails(List<AttendanceDetail> attendanceDetails) {
		this.attendanceDetails=attendanceDetails;
	}
	public List<AttendanceDetail> getAttendanceDetails() {
		return attendanceDetails;
	}
	@Override
	public String toString() {
		return
			"Attenance [id="+id+", date="+date+", total="+total+", actual="+actual+", note="+note+", course="+course+", attendanceDetails="+attendanceDetails+"]";
	}
}