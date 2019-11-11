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
	private Integer user;//用户ID
	private Integer image;//照片ID
	private Integer clazz;//班级ID
	private List<Integer> courses;//该学生课程集合
	private List<Integer> attendanceDetails;//该学生考勤信息集合
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
	public void setUser(Integer user) {
		this.user=user;
	}
	public Integer getUser() {
		return user;
	}
	public void setImage(Integer image) {
		this.image=image;
	}
	public Integer getImage() {
		return image;
	}
	public void setClazz(Integer clazz) {
		this.clazz=clazz;
	}
	public Integer getClazz() {
		return clazz;
	}
	public void setCourses(List<Integer> courses) {
		this.courses=courses;
	}
	public List<Integer> getCourses() {
		return courses;
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
			"Student [id="+id+", name="+name+", uid="+uid+", sex="+sex+", birthday="+birthday+", admissiontime="+admissiontime+", nativeplace="+nativeplace+", address="+address+", postcode="+postcode+", profession="+profession+", user="+user+", image="+image+", clazz="+clazz+", courses="+courses+", attendanceDetails="+attendanceDetails+"]";
	}
}