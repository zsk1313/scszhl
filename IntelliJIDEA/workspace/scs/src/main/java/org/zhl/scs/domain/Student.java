package org.zhl.scs.domain;

import java.io.Serializable;

import java.util.Date;

import java.util.List;

/**
 * 学生信息Domain
 * @author zsk
 *
 */
public class Student implements Serializable {
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
	private User user;//用户ID
	private Image image;//照片ID
	private Clazz clazz;//班级ID
	private List<Course> courses;//该学生课程集合
	private List<AttendanceDetail> attendanceDetails;//该学生考勤信息集合
	public Student() {}
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
	public void setUser(User user) {
		this.user=user;
	}
	public User getUser() {
		return user;
	}
	public void setImage(Image image) {
		this.image=image;
	}
	public Image getImage() {
		return image;
	}
	public void setClazz(Clazz clazz) {
		this.clazz=clazz;
	}
	public Clazz getClazz() {
		return clazz;
	}
	public void setCourses(List<Course> courses) {
		this.courses=courses;
	}
	public List<Course> getCourses() {
		return courses;
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
			"Student [id="+id+", name="+name+", uid="+uid+", sex="+sex+", birthday="+birthday+", admissiontime="+admissiontime+", nativeplace="+nativeplace+", address="+address+", postcode="+postcode+", profession="+profession+", user="+user+", image="+image+", clazz="+clazz+", courses="+courses+", attendanceDetails="+attendanceDetails+"]";
	}
}