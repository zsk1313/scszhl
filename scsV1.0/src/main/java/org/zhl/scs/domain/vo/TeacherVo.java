package org.zhl.scs.domain.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 教师Domain类
 * @author zsk
 *
 */
public class TeacherVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;//id主键
	private String name;//教师姓名
	private String uid;//教师编号
	private String sex;//性别
	private Date birthday;//出生日期
	private Date entertime;//入职时间
	private String address;//地址
	private String description;//简历
	private Integer userId;//用户id
	private Integer imageId;//照片id
	private Integer jobId;//职称id
	private List<Integer> clazzIds;//班主任为该老师的班级集合
	TeacherVo() {}
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
	public void setEntertime(Date entertime) {
		this.entertime=entertime;
	}
	public Date getEntertime() {
		return entertime;
	}
	public void setAddress(String address) {
		this.address=address;
	}
	public String getAddress() {
		return address;
	}
	public void setDescription(String description) {
		this.description=description;
	}
	public String getDescription() {
		return description;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getImageId() {
		return imageId;
	}
	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}
	public Integer getJobId() {
		return jobId;
	}
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}
	public List<Integer> getClazzIds() {
		return clazzIds;
	}
	public void setClazzIds(List<Integer> clazzIds) {
		this.clazzIds = clazzIds;
	}
	@Override
	public String toString() {
		return
			"Teacher [id="+id+", name="+name+", uid="+uid+", sex="+sex+", birthday="+birthday+", entertime="+entertime+", address="+address+", description="+description+", userId="+userId+", imageId="+imageId+", jobId="+jobId+", clazzIds="+clazzIds+"]";
	}
}