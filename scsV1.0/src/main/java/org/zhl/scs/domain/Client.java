package org.zhl.scs.domain;

import java.io.Serializable;

import java.util.List;
/**
 * 客户控制终端Domain
 * @author zsk
 *
 */
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;//ID主键
	private String name;//客户控制终端名称
	private List<SensorNode> sensorNodes;//传感器节点集合
	private List<ControllerNode> controllerNodes;//控制器节点集合
	public Client() {}
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
	public void setSensorNodes(List<SensorNode> sensorNodes) {
		this.sensorNodes=sensorNodes;
	}
	public List<SensorNode> getSensorNodes() {
		return sensorNodes;
	}
	public void setControllerNodes(List<ControllerNode> controllerNodes) {
		this.controllerNodes=controllerNodes;
	}
	public List<ControllerNode> getControllerNodes() {
		return controllerNodes;
	}
	@Override
	public String toString() {
		return
			"Client [id="+id+", name="+name+", sensorNodes="+sensorNodes+", controllerNodes="+controllerNodes+"]";
	}
}