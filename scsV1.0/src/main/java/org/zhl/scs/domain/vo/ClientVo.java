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
	private List<Integer> sensorNodes;//传感器节点集合
	private List<Integer> controllerNodes;//控制器节点集合
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
	public void setSensorNodes(List<Integer> sensorNodes) {
		this.sensorNodes=sensorNodes;
	}
	public List<Integer> getSensorNodes() {
		return sensorNodes;
	}
	public void setControllerNodes(List<Integer> controllerNodes) {
		this.controllerNodes=controllerNodes;
	}
	public List<Integer> getControllerNodes() {
		return controllerNodes;
	}
	@Override
	public String toString() {
		return
			"Client [id="+id+", name="+name+", sensorNodes="+sensorNodes+", controllerNodes="+controllerNodes+"]";
	}
}