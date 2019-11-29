package org.zhl.scs.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

import java.util.Date;
/**
 * 传感器节点Domain
 * @author zsk
 *
 */
public class SensorNode implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;//id主键
	private String code;//编号
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date time;//时间
	private String type;//类型
	private String status;//状态
	private String fundescription;//功能描述
	private String address;//地址
	private String flag;//标志位
	private Client client;//客户控制终端id
	public SensorNode() {}
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
	public void setClient(Client client) {
		this.client=client;
	}
	public Client getClient() {
		return client;
	}
	@Override
	public String toString() {
		return
			"SensorNode [id="+id+", code="+code+", time="+time+", type="+type+", status="+status+", fundescription="+fundescription+", address="+address+", flag="+flag+", client="+client+"]";
	}
}