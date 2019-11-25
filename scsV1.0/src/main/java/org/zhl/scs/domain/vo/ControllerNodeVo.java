package org.zhl.scs.domain.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 控制器Domain
 * @author zsk
 *
 */
public class ControllerNodeVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;//id主键
	private String code;//编号
	private Date time;//时间
	private String type;//类型
	private String status;//状态
	private String value;//数值
	private String address;//地址
	private String flag;//标志位
	private Integer clientId;//客户控制终端
	private String controlCode; //控制代码
	public ControllerNodeVo() {}
	public String getControlCode() {
		return controlCode;
	}
	public void setControlCode(String controlCode) {
		this.controlCode = controlCode;
	}
	public void setId(Integer id) {
		this.id=id;
	}
	public Integer getId() {
		return id;
	}
	public void setCode(String code) {
		this.code=code;
	}
	public String getCode() {
		return code;
	}
	public void setTime(Date time) {
		this.time=time;
	}
	public Date getTime() {
		return time;
	}
	public void setType(String type) {
		this.type=type;
	}
	public String getType() {
		return type;
	}
	public void setStatus(String status) {
		this.status=status;
	}
	public String getStatus() {
		return status;
	}
	public void setValue(String value) {
		this.value=value;
	}
	public String getValue() {
		return value;
	}
	public void setAddress(String address) {
		this.address=address;
	}
	public String getAddress() {
		return address;
	}
	public void setFlag(String flag) {
		this.flag=flag;
	}
	public String getFlag() {
		return flag;
	}
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	@Override
	public String toString() {
		return "ControllerNodeVo{" +
				"id=" + id +
				", code='" + code + '\'' +
				", time=" + time +
				", type='" + type + '\'' +
				", status='" + status + '\'' +
				", value='" + value + '\'' +
				", address='" + address + '\'' +
				", flag='" + flag + '\'' +
				", clientId=" + clientId +
				", controlCode='" + controlCode + '\'' +
				'}';
	}
}