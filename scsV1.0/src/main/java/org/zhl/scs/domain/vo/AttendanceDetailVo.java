package org.zhl.scs.domain.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 考勤信息条Domain
 * @author zsk
 *
 */
public class AttendanceDetailVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;//id主键
	private Integer isattendance;//是否出勤
	private Integer studentId;//该考勤信息所属学生
	private Integer attenanceId;//该考勤信息所属考勤表
	private Date signTime;//签到时间
	public AttendanceDetailVo() {}
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
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public void setAttenanceId(Integer attenanceId) {
		this.attenanceId=attenanceId;
	}
	public Integer getAttenanceId() { return attenanceId; }

	public Date getSignTime() {
		return signTime;
	}

	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}

	@Override
	public String toString() {
		return
			"AttendanceDetail [id="+id+", isattendance="+isattendance+", studentId="+studentId+", attenanceId="+attenanceId+",signTime="+signTime+"]";
	}
}