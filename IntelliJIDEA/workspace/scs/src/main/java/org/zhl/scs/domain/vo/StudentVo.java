package org.zhl.scs.domain.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 学生信息Domain
 * @author zsk
 *
 */
public class StudentVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;//ID主键
	private String name;//学生姓名
	private String uid;//学号
	private String sex;//性别
	private Date birthday;//出生
	private Date admissiontime;//入学时间
	private String nativeplace;//籍贯
	private String address;//地址
	private String postcode;//邮编
	private String profession;//专业
	private Integer userId;//用户ID
	private Integer imageId;//照片ID
	private Integer clazzId;//班级ID
	private List<Integer> courseIds;//该学生课程集合
	private List<Integer> attendanceDetailIds;//该学生考勤信息集合
	public StudentVo() {}
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
	public void setUid(String uid) {
		this.uid=uid;
	}
	public String getUid() {
		return uid;
	}
	public void setSex(String sex) {
		this.sex=sex;
	}
	public String getSex() {
		return sex;
	}
	public void setBirthday(Date birthday) {
		this.birthday=birthday;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setAdmissiontime(Date admissiontime) {
		this.admissiontime=admissiontime;
	}
	public Date getAdmissiontime() {
		return admissiontime;
	}
	public void setNativeplace(String nativeplace) {
		this.nativeplace=nativeplace;
	}
	public String getNativeplace() {
		return nativeplace;
	}
	public void setAddress(String address) {
		this.address=address;
	}
	public String getAddress() {
		return address;
	}
	public void setPostcode(String postcode) {
		this.postcode=postcode;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setProfession(String profession) {
		this.profession=profession;
	}
	public String getProfession() {
		return profession;
	}
	@Override
	public String toString() {
		return
			"Student [id="+id+", name="+name+", uid="+uid+", sex="+sex+", birthday="+birthday+", admissiontime="+admissiontime+", nativeplace="+nativeplace+", address="+address+", postcode="+postcode+", profession="+profession+", userId="+userId+", imageId="+imageId+", clazzId="+clazzId+", courseIds="+courseIds+", attendanceDetailIds="+attendanceDetailIds+"]";
	}
}