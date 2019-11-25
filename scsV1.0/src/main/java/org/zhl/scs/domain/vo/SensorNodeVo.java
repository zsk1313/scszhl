package org.zhl.scs.domain.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 传感器节点Domain
 * @author zsk
 *
 */
public class SensorNodeVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;//id主键
	private String code;//编号
	private Date time;//时间
	private String type;//类型
	private String status;//状态
	private String fundescription;//功能描述
	private String address;//地址
	private String flag;//标志位
	private Integer clientId;//客户控制终端id
	private String value;  //传感器数值
	private String[] thresholdValue = new String[2];  //传感器阈值
	public SensorNodeVo() {}
	public String[] getThresholdValue() {
		return thresholdValue;
	}
	public void setThresholdValue(String[] thresholdValue) {
		this.thresholdValue = thresholdValue;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
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
	public void setFundescription(String fundescription) {
		this.fundescription=fundescription;
	}
	public String getFundescription() {
		return fundescription;
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
		return "SensorNodeVo{" +
				"id=" + id +
				", code='" + code + '\'' +
				", time=" + time +
				", type='" + type + '\'' +
				", status='" + status + '\'' +
				", fundescription='" + fundescription + '\'' +
				", address='" + address + '\'' +
				", flag='" + flag + '\'' +
				", clientId=" + clientId +
				", value='" + value + '\'' +
				", thresholdValue='" + thresholdValue + '\'' +
				'}';
	}
}