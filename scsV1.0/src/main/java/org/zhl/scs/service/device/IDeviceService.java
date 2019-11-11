package org.zhl.scs.service.device;

import org.zhl.scs.domain.Client;
import org.zhl.scs.domain.ControllerNode;
import org.zhl.scs.domain.SensorNode;
import org.zhl.scs.domain.vo.ClientVo;
import org.zhl.scs.domain.vo.ControllerNodeVo;
import org.zhl.scs.domain.vo.SensorNodeVo;

import java.util.List;

/**
 * 设备监控
 */
public interface IDeviceService {

    /**
     * 添加设备
     * @param device
     */
    void saveDevice(Object device);

    /**
     * 更新设备
     * @param device
     */
    void updateDevice(Object device);

    /**
     * 删除设备
     * @param device
     */
    void deleteDevice(Object device);

    //--------环境监控--------

    /**
     * 获取个传感器节点数据
     *
     * @param clientVo 客户端id
     * @return
     */
    List<SensorNode> readSensors(ClientVo clientVo);

    /**
     * 传感器数据法制判断
     *
     * @param SensorNodeVo 传感器
     * @return
     */
    Object determineSensorValue(SensorNodeVo SensorNodeVo);

    /**
     * 报警（未完成）
     *
     * @param SensorNodeVo 传感器
     * @return
     */
    Object sensorPolice(SensorNodeVo SensorNodeVo);

    /**
     * 排险（未完成）
     *
     * @param SensorNodeVo 传感器
     * @return
     */
    Object sensorZone(SensorNodeVo SensorNodeVo);

    //--------控制系统---------

    /**
     * 读取控制器数值
     *
     * @param clientVo
     * @return
     */
    List<ControllerNode> readControllerNode(ClientVo clientVo);

    /**
     * 控制室内设备
     *
     * @param ControllerNodeVo
     */
    void controllerDevice(ControllerNodeVo ControllerNodeVo);

    /**
     * 环境自动响应
     *
     * @param ControllerNodeVo
     */
    void autoController(ControllerNodeVo ControllerNodeVo);

    /**
     * 安全应急预案
     *
     * @param ControllerNodeVo
     */
    void contingencyPlan(ControllerNodeVo ControllerNodeVo);

}
