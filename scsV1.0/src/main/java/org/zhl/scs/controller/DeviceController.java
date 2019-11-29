package org.zhl.scs.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zhl.scs.domain.Client;
import org.zhl.scs.domain.ControllerNode;
import org.zhl.scs.domain.SensorNode;
import org.zhl.scs.domain.vo.ClientVo;
import org.zhl.scs.domain.vo.ControllerNodeVo;
import org.zhl.scs.domain.vo.SensorNodeVo;
import org.zhl.scs.reponse.RespBean;
import org.zhl.scs.service.device.IDeviceService;
import org.zhl.scs.util.AssignByFieldName;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    private IDeviceService deviceService;

    /**
     * 查询客户端列表
     *
     * @return 客户端集合
     */
    @GetMapping("/selectClient")
    public List<Client> selectClient() {
        return deviceService.selectAllClient();
    }

    /**
     * 查询传感器集合
     *
     * @param clientVo 客户端id
     * @return 传感器集合
     */
    @GetMapping("/listSensor")
    public List<SensorNode> getSensorNode(ClientVo clientVo) {
        return deviceService.readSensors(clientVo);
    }

    /**
     * 查询控制器集合
     *
     * @param clientVo 客户端id
     * @return 控制器集合
     */
    @GetMapping("/listController")
    public List<ControllerNode> getControllerNode(ClientVo clientVo) {
        return deviceService.readControllerNodes(clientVo);
    }

    /**
     * 更新传感器信息
     *
     * @param sensorNodeVo 传感器信息
     * @return 响应bean
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @PutMapping("/updateSensor")
    public RespBean updateSensorNode(SensorNodeVo sensorNodeVo) throws InvocationTargetException, IllegalAccessException {
        //System.out.println(request.getParameter("formData"));
        //SensorNodeVo sensorNodeVo = JSON.parseObject(request.getParameter("formData"), SensorNodeVo.class);
        System.out.println(sensorNodeVo);
        RespBean respBean = RespBean.build();
//        SensorNode sensorNode = new SensorNode();
//        AssignByFieldName.getInstance().Assign(sensorNodeVo, sensorNode);
        deviceService.updateDevice(sensorNodeVo);
        respBean.setMsg("更新成功！");
        return respBean;
    }

    /**
     * 新增传感器
     *
     * @param sensorNodeVo 传感器信息
     * @return 响应bean
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @PostMapping("/insertSensor")
    public RespBean insertSensor(SensorNodeVo sensorNodeVo) throws InvocationTargetException, IllegalAccessException {
        //SensorNodeVo sensorNode = JSON.parseObject(request.getParameter("sensorNode"), SensorNodeVo.class);
        System.out.println(sensorNodeVo);
        RespBean respBean = RespBean.build();
        deviceService.saveDevice(sensorNodeVo);
        respBean.setMsg("保存成功！");
        return respBean;
    }

    /**
     * 移除传感器
     *
     * @param sensorNodeVo 传感器id
     * @return 响应bean
     */
    @DeleteMapping("/deleteSensor")
    public RespBean deleteSensor(SensorNodeVo sensorNodeVo) {
        System.out.println(sensorNodeVo);
        RespBean respBean = RespBean.build();
        if (sensorNodeVo.getId() != null) {
            deviceService.deleteDevice(sensorNodeVo);
        } else {
            throw new IllegalArgumentException("id 为空");
        }
        respBean.setMsg("删除成功！");
        return respBean;
    }

    /**
     * 更新控制器信息
     *
     * @param controllerNodeVo 控制器信息
     * @return 响应bean
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @PutMapping("/updateController")
    public RespBean updateControllerNode(ControllerNodeVo controllerNodeVo) throws InvocationTargetException, IllegalAccessException {
        System.out.println(controllerNodeVo);
        RespBean respBean = RespBean.build();
        deviceService.updateDevice(controllerNodeVo);
        respBean.setMsg("更新成功！");
        return respBean;
    }

    /**
     * 新增控制器
     *
     * @param controllerNodeVo 控制器信息
     * @return 响应bean
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @PostMapping("/insertController")
    public RespBean insertController(ControllerNodeVo controllerNodeVo) throws InvocationTargetException, IllegalAccessException {
        System.out.println(controllerNodeVo);
        RespBean respBean = RespBean.build();
        deviceService.saveDevice(controllerNodeVo);
        respBean.setMsg("保存成功！");
        return respBean;
    }

    /**
     * 移除控制器
     *
     * @param controllerNodeVo 控制器id
     * @return 响应bean
     */
    @DeleteMapping("/deleteController")
    public RespBean deleteController(ControllerNodeVo controllerNodeVo) {
        System.out.println(controllerNodeVo);
        RespBean respBean = RespBean.build();
        if (controllerNodeVo.getId() != null) {
            deviceService.deleteDevice(controllerNodeVo);
        } else {
            throw new IllegalArgumentException("id 为空");
        }
        respBean.setMsg("删除成功！");
        return respBean;
    }

    //监控传感器数据

    //控制控制器

    //控制方案

    //应急预案

}
