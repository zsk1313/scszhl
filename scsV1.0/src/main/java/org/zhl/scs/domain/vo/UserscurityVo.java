package org.zhl.scs.domain.vo;

import java.io.Serializable;

/**
 * 用户安全认证信息Domain
 * @author zsk
 *
 */
public class UserscurityVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;//id主键
	private String fingerpoint;//指纹信息
	private String faceid;//人脸信息
	private String cardid;//通行卡信息
	private Integer userId;//用户id
	public UserscurityVo() {}
	public void setId(Integer id) {
		this.id=id;
	}
	public Integer getId() {
		return id;
	}
	public void setFingerpoint(String fingerpoint) {
		this.fingerpoint=fingerpoint;
	}
	public String getFingerpoint() {
		return fingerpoint;
	}
	public void setFaceid(String faceid) {
		this.faceid=faceid;
	}
	public String getFaceid() {
		return faceid;
	}
	public void setCardid(String cardid) {
		this.cardid=cardid;
	}
	public String getCardid() {
		return cardid;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return
			"Studentscurity [id="+id+", fingerpoint="+fingerpoint+", faceid="+faceid+", cardid="+cardid+", userId="+userId+"]";
	}
}