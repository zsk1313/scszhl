package org.zhl.scs.domain.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 考勤Domain
 * @author zsk
 *
 */
public class AttenanceVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;//id主键
	private Date date;//日期
	private Integer total;//应到人数
	private Integer actual;//实到人数
	private String note;//备注
	private Integer clazz;//班级
	private Integer course;//课程
	private List<Integer> attendanceDetails;//考勤信息条集合
	public AttenanceVo() {}
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
	public void setClazz(Integer clazz) {
		this.clazz=clazz;
	}
	public Integer getClazz() {
		return clazz;
	}
	public void setCourse(Integer course) {
		this.course=course;
	}
	public Integer getCourse() {
		return course;
	}
	public void setAttendanceDetails(List<Integer> attendanceDetails) {
		this.attendanceDetails=attendanceDetails;
	}
	public List<Integer> getAttendanceDetails() {
		return attendanceDetails;
	}
	@Override
	public String toString() {
		return
			"Attenance [id="+id+", date="+date+", total="+total+", actual="+actual+", note="+note+", clazz="+clazz+", course="+course+", attendanceDetails="+attendanceDetails+"]";
	}
}