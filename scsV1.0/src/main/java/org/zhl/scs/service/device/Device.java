package org.zhl.scs.service.device;

import org.zhl.scs.domain.vo.ClientVo;
import org.zhl.scs.domain.vo.ControllerNodeVo;
import org.zhl.scs.domain.vo.SensorNodeVo;

import java.io.IOException;

/**
 * 物理设备接口
 *
 * @author lzs
 * @version v1.0
 */
public interface Device {

    /**
     * 获取传感器数值
     *
     * @param sensorNodeVo 传感器信息
     * @return
     */
    Object getSensorValue(SensorNodeVo sensorNodeVo) throws IOException;

    /**
     * 通知设备报警
     * @param clientVo 客户端信息
     * @return
     */
    Object police(ClientVo clientVo);

    /**
     * 通知设备排险
     * @param clientVo 客户端信息
     * @return
     */
    Object zone(ClientVo clientVo);

    /**
     * 控制控制器
     * @param controllerNodeVo 控制器信息
     * @return
     */
    Object control(ControllerNodeVo controllerNodeVo);

    /**
     * 获取控制器参数
     * @param controllerNodeVo 控制器信息
     * @return
     */
    Object readController(ControllerNodeVo controllerNodeVo);

}
