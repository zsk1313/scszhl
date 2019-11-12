package org.zhl.scs.domain.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 客户控制终端Domain
 * @author zsk
 *
 */
public class ClientVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;//ID主键
	private String name;//客户控制终端名称
	private List<Integer> sensorNodeIds;//传感器节点集合
	private List<Integer> controllerNodeIds;//控制器节点集合
	public ClientVo() {}
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
	public List<Integer> getSensorNodeIds() {
		return sensorNodeIds;
	}
	public void setSensorNodeIds(List<Integer> sensorNodeIds) {
		this.sensorNodeIds = sensorNodeIds;
	}
	public List<Integer> getControllerNodeIds() {
		return controllerNodeIds;
	}
	public void setControllerNodeIds(List<Integer> controllerNodeIds) {
		this.controllerNodeIds = controllerNodeIds;
	}
	@Override
	public String toString() {
		return
			"Client [id="+id+", name="+name+", sensorNodeIds="+sensorNodeIds+", controllerNodeIds="+controllerNodeIds+"]";
	}
}