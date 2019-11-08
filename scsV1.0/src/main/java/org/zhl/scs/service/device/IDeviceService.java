package org.zhl.scs.service.device;

import org.zhl.scs.domain.Client;
import org.zhl.scs.domain.ControllerNode;
import org.zhl.scs.domain.SensorNode;

import java.util.List;

/**
 * 设备监控
 */
public interface IDeviceService {

    //--------环境监控--------

    /**
     * 获取个传感器节点数据
     *
     * @param client 客户端id
     * @return
     */
    List<SensorNode> readSensors(Client client);

    /**
     * 传感器数据法制判断
     *
     * @param SensorNode 传感器
     * @return
     */
    Object determineSensorValue(SensorNode SensorNode);

    /**
     * 报警（未完成）
     *
     * @param SensorNode 传感器
     * @return
     */
    Object sensorPolice(SensorNode SensorNode);

    /**
     * 排险（未完成）
     *
     * @param SensorNode 传感器
     * @return
     */
    Object sensorZone(SensorNode SensorNode);

    //--------控制系统---------

    /**
     * 读取控制器数值
     *
     * @param client
     * @return
     */
    List<ControllerNode> readControllerNode(Client client);

    /**
     * 控制室内设备
     *
     * @param ControllerNode
     */
    void controllerDevice(ControllerNode ControllerNode);

    /**
     * 环境自动响应
     *
     * @param ControllerNode
     */
    void autoController(ControllerNode ControllerNode);

    /**
     * 安全应急预案
     *
     * @param ControllerNode
     */
    void contingencyPlan(ControllerNode ControllerNode);

}
