package org.zhl.scs.service.device;

import org.zhl.scs.domain.Client;
import org.zhl.scs.domain.ControllerNode;
import org.zhl.scs.domain.SensorNode;
import org.zhl.scs.domain.vo.ClientVo;
import org.zhl.scs.domain.vo.ControllerNodeVo;
import org.zhl.scs.domain.vo.SensorNodeVo;
import org.zhl.scs.service.device.scheme.ControlScheme;
import org.zhl.scs.util.common.devices.DeviceControl;
import org.zhl.scs.util.common.devices.Sensor;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * 设备监控
 *
 * @author lzs
 * @version 2.0
 */
public interface IDeviceService {

    /**
     * 添加设备
     *
     * @param device
     */
    void saveDevice(Object device);

    /**
     * 更新设备
     *
     * @param device
     */
    void updateDevice(Object device);

    /**
     * 删除设备
     *
     * @param device
     */
    void deleteDevice(Object device);

    /**
     * 查询全部传感器
     *
     * @return
     */
    List<SensorNode> selectAllSensor();

    /**
     * 查询全部控制器
     *
     * @return
     */
    List<ControllerNode> selectAllController();

    //--------环境监控--------

    /**
     * 获取个传感器节点数据
     *
     * @param clientVo 客户端id
     * @return
     */
    List<SensorNode> readSensors(ClientVo clientVo);

    /**
     * 分页查询传感器数据
     *
     * @param item 包含一个 clientVo 和 pageModel
     * @return
     */
    List<SensorNode> readSensorsByPage(Map<String, Object> item) throws InvocationTargetException, IllegalAccessException;

    /**
     * 读取传感器
     *
     * @param sensorNodeVo
     * @return
     */
    List<SensorNode> readSensor(SensorNodeVo sensorNodeVo) throws InvocationTargetException, IllegalAccessException;

    /**
     * 从传感器设备获取传感器数值
     *
     * @param clientVos 客户端集合
     * @return 返回一个map，(key-ClientVo, value-List<SensorNodeVo>)
     */
    Map<Object, Object> getSensorsDeviceValue(List<ClientVo> clientVos) throws InvocationTargetException, IllegalAccessException, IOException;

    /**
     * 获取单个传感器
     *
     * @param clientVo 客户端信息
     * @param sensor   传感器类型
     * @return
     */
    SensorNodeVo getSingleSensor(ClientVo clientVo, Sensor sensor) throws InvocationTargetException, IllegalAccessException;

    /**
     * 获取单个传感器数值
     *
     * @param sensorNodeVo
     * @return
     */
    SensorNodeVo getSingleSensorValue(SensorNodeVo sensorNodeVo) throws IOException;

    /**
     * 传感器数据阈值判断（用户自定义阈值）
     *
     * @param item 包含客户端信息、传感器类型-设置阈值（长度为2的数组，0为最低值，1为最大值）、
     * @return
     */
    void determineSensorValue(Map<Object, Object> item) throws Exception;

    /**
     * 报警（未完成）
     *
     * @param clientVo 传感器
     * @return
     */
    Object sensorPolice(ClientVo clientVo);

    /**
     * 排险（未完成）
     *
     * @param clientVo 传感器
     * @return
     */
    Object sensorZone(ClientVo clientVo);

    //--------控制系统---------

    /**
     * 读取控制器数值
     *
     * @param clientVo
     * @return
     */
    List<ControllerNode> readControllerNodes(ClientVo clientVo);

    /**
     * 分页查询控制器
     *
     * @param item
     * @return
     */
    List<ControllerNode> readControllerNodesByPage(Map<String, Object> item) throws InvocationTargetException, IllegalAccessException;

    /**
     * 查询控制器
     *
     * @param controllerNodeVo 控制器信息
     * @return
     */
    List<ControllerNode> readControllerNode(ControllerNodeVo controllerNodeVo) throws InvocationTargetException, IllegalAccessException;

    /**
     * 获取单个控制器
     *
     * @param clientVo 客户端信息
     * @param device   设备类型
     * @return
     */
    ControllerNodeVo getSingleControllerNode(ClientVo clientVo, DeviceControl device) throws InvocationTargetException, IllegalAccessException;

    /**
     * 获取控制器参数
     *
     * @param controllerNodeVo 控制器信息
     * @return
     */
    ControllerNodeVo getSingleControllerNodeValue(ControllerNodeVo controllerNodeVo);

    /**
     * 控制室内设备
     *
     * @param item 包含controllerVo，设备控制类型，操作类型，操做数值
     */
    void deviceControl(Map<String, Object> item);

    /**
     * 环境自动响应
     *
     * @param controlScheme 阈值方案
     */
    void autoControl(ControlScheme controlScheme) throws Exception;

    /**
     * 温湿度自动响应，空调控制
     *
     * @param clientVo       客户端信息
     * @param value          设备类型-数值
     * @param humiditySensor 温湿度传感器
     * @param ac             空调
     */
    void humidity_autoControl(ClientVo clientVo, Map<Object, Object> value, SensorNodeVo humiditySensor, ControllerNodeVo ac) throws Exception;

    /**
     * 烟雾与PM2.5自动响应，风扇控制
     *
     * @param clientVo    客户端信息
     * @param value       设备类型-数值
     * @param smokeSensor 烟雾传感器
     * @param pm25Sensor  PM2.5传感器
     * @param fan         风扇
     */
    void smokeAndPM25_autoControl(ClientVo clientVo, Map<Object, Object> value, SensorNodeVo smokeSensor, SensorNodeVo pm25Sensor, ControllerNodeVo fan) throws Exception;

    /**
     * 光照度自动响应，窗帘控制和照明控制
     *
     * @param clientVo    客户端信息
     * @param value       设备类型-数值
     * @param lightSensor 光照传感器
     * @param curtain     窗帘
     * @param light       灯光
     */
    void light_autoControl(ClientVo clientVo, Map<Object, Object> value, SensorNodeVo lightSensor, ControllerNodeVo light, ControllerNodeVo curtain) throws Exception;

    /**
     * 安全应急预案
     *
     * @param ControllerNodeVo
     */
    void contingencyPlan(ControllerNodeVo ControllerNodeVo);

}
