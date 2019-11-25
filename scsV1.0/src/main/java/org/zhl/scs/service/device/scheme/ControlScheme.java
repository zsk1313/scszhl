package org.zhl.scs.service.device.scheme;

import org.zhl.scs.domain.vo.ClientVo;
import org.zhl.scs.domain.vo.ControllerNodeVo;
import org.zhl.scs.domain.vo.SensorNodeVo;
import org.zhl.scs.util.common.devices.DeviceControlType;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 封装设备控制方案，以一个clientVo为一个单位
 * @author lzs
 * @version v1.0
 */
public class ControlScheme implements Serializable {

    private DeviceControlType type; //传入枚举类org.zhl.scs.util.common.DeviceControlType，定义操作类型
    private ClientVo clientVo; //客户端信息
    //传感器阈值
//    private Map<Object, Object> sensorValue;
    private Map<Object, Object> humidity;  //温度传感器方案
    private Map<Object, Object> light;     //光照度传感器方案
    private Map<Object, Object> smokeAndPM25;  //烟雾与PM2.5方案

    private ControllerNodeVo controllerNodeVo;  //控制器数据
    private SensorNodeVo sensorNodeVo;  //传感器数据

    public ControlScheme() {
    }

    public ControlScheme(DeviceControlType type, ClientVo clientVo) {
        this.type = type;
        this.clientVo = clientVo;
    }

    public SensorNodeVo getSensorNodeVo() {
        return sensorNodeVo;
    }

    public void setSensorNodeVo(SensorNodeVo sensorNodeVo) {
        this.sensorNodeVo = sensorNodeVo;
    }

    public DeviceControlType getType() {
        return type;
    }

    public void setType(DeviceControlType type) {
        this.type = type;
    }

    public ClientVo getClientVo() {
        return clientVo;
    }

    public void setClientVo(ClientVo clientVo) {
        this.clientVo = clientVo;
    }

    public Map<Object, Object> getHumidity() {
        return humidity;
    }

    public void setHumidity(Map<Object, Object> humidity) {
        this.humidity = humidity;
    }

    public Map<Object, Object> getLight() {
        return light;
    }

    public void setLight(Map<Object, Object> light) {
        this.light = light;
    }

    public Map<Object, Object> getSmokeAndPM25() {
        return smokeAndPM25;
    }

    public void setSmokeAndPM25(Map<Object, Object> smokeAndPM25) {
        this.smokeAndPM25 = smokeAndPM25;
    }

    public ControllerNodeVo getControllerNodeVo() {
        return controllerNodeVo;
    }

    public void setControllerNodeVo(ControllerNodeVo controllerNodeVo) {
        this.controllerNodeVo = controllerNodeVo;
    }

    @Override
    public String toString() {
        return "ControlScheme{" +
                "type=" + type +
                ", clientVo=" + clientVo +
                ", humidity=" + humidity +
                ", light=" + light +
                ", smokeAndPM25=" + smokeAndPM25 +
                ", controllerNodeVo=" + controllerNodeVo +
                ", sensorNodeVo=" + sensorNodeVo +
                '}';
    }
}
