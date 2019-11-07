package org.zhl.scs.domain;

import java.io.Serializable;
/**
 * 考勤信息条Domain
 * @author zsk
 *
 */
public class AttendanceDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;//id主键
	private Integer isattendance;//是否出勤
	private Student student;//改考勤信息所属学生
	private Attenance attenance;//该考勤信息所属考勤表
	public AttendanceDetail() {}
	public void setId(Integer id) {
		this.id=id;
	}
	public Integer getId() {
		return id;
	}
	public void setIsattendance(Integer isattendance) {
		this.isattendance=isattendance;
	}
	public Integer getIsattendance() {
		return isattendance;
	}
	public void setStudent(Student student) {
		this.student=student;
	}
	public Student getStudent() {
		return student;
	}
	public void setAttenance(Attenance attenance) {
		this.attenance=attenance;
	}
	public Attenance getAttenance() {
		return attenance;
	}
	@Override
	public String toString() {
		return
			"AttendanceDetail [id="+id+", isattendance="+isattendance+", student="+student+", attenance="+attenance+"]";
	}
}