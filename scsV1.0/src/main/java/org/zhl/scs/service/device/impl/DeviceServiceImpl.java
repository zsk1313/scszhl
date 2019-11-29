package org.zhl.scs.service.device.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.zhl.scs.dao.ClientDao;
import org.zhl.scs.dao.ControllerNodeDao;
import org.zhl.scs.dao.SensorNodeDao;
import org.zhl.scs.domain.Client;
import org.zhl.scs.domain.ControllerNode;
import org.zhl.scs.domain.SensorNode;
import org.zhl.scs.domain.vo.ClientVo;
import org.zhl.scs.domain.vo.ControllerNodeVo;
import org.zhl.scs.domain.vo.SensorNodeVo;
import org.zhl.scs.service.device.Device;
import org.zhl.scs.service.device.IDeviceService;
import org.zhl.scs.service.device.scheme.ControlScheme;
import org.zhl.scs.util.AssignByFieldName;
import org.zhl.scs.util.PageModel;
import org.zhl.scs.util.common.devices.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 设备控制业务逻辑实现类
 *
 * @author lzs
 * @version v1.0
 */
@Service
public class DeviceServiceImpl implements IDeviceService {

    @Autowired
    private ClientDao clientDao;
    @Autowired
    private SensorNodeDao sensorNodeDao;
    @Autowired
    private ControllerNodeDao controllerNodeDao;
    @Autowired
    private Device device;

    /**
     * @param device 设备（传感器or控制器）
     * @see IDeviceService
     */
    @Transactional
    @Override
    public void saveDevice(Object device) throws InvocationTargetException, IllegalAccessException {
        if (device == null) {
            throw new IllegalArgumentException("设备数据不能为空");
        }
        //判断device类型（传感器 or 控制器）
        if (device instanceof SensorNode) {
            //传感器
            sensorNodeDao.save((SensorNode) device);
            System.out.println("----Service层---- 保存为传感器" + "\n" + device);
        } else if (device instanceof ControllerNode) {
            //控制器
            controllerNodeDao.save((ControllerNode) device);
            System.out.println("----Service层---- 保存为控制器" + "\n" + device);
        } else if (device instanceof SensorNodeVo) {
            SensorNode sensorNode = new SensorNode();
            AssignByFieldName.getInstance().Assign(device, sensorNode);
            int cid = ((SensorNodeVo) device).getClientId();
            if (!StringUtils.isEmpty(cid)) {
                Client client = new Client();
                client.setId(cid);
                sensorNode.setClient(client);
            } else {
                throw new IllegalArgumentException("客户端id不能为空");
            }
            sensorNodeDao.save(sensorNode);
            System.out.println("----Service层---- 保存为传感器" + "\n" + device);
        } else if (device instanceof ControllerNodeVo) {
            ControllerNode controllerNode = new ControllerNode();
            AssignByFieldName.getInstance().Assign(device, controllerNode);
            int cid = ((ControllerNodeVo) device).getClientId();
            if (!StringUtils.isEmpty(cid)) {
                Client client = new Client();
                client.setId(cid);
                controllerNode.setClient(client);
            } else {
                throw new IllegalArgumentException("客户端id不能为空");
            }
            controllerNodeDao.save(controllerNode);
            System.out.println("----Service层---- 保存为控制器" + "\n" + device);
        } else {
            throw new IllegalArgumentException("设备数据非法");
        }
    }

    /**
     * @param device
     * @see IDeviceService
     */
    @Transactional
    @Override
    public void updateDevice(Object device) throws InvocationTargetException, IllegalAccessException {
        if (device == null) {
            throw new IllegalArgumentException("设备数据不能为空");
        }
        //判断device类型（传感器 or 控制器）
        if (device instanceof SensorNode) {
            //传感器
            sensorNodeDao.update((SensorNode) device);
            System.out.println("Service层---- 更新传感器" + "\n" + device);
        } else if (device instanceof ControllerNode) {
            //控制器
            controllerNodeDao.update((ControllerNode) device);
            System.out.println("Service层---- 更新控制器" + "\n" + device);
        } else if (device instanceof SensorNodeVo) {
            SensorNode sensorNode = new SensorNode();
            AssignByFieldName.getInstance().Assign(device, sensorNode);
            sensorNodeDao.update(sensorNode);
            System.out.println("Service层---- 更新传感器" + "\n" + device);
        } else if (device instanceof ControllerNodeVo) {
            ControllerNode controllerNode = new ControllerNode();
            AssignByFieldName.getInstance().Assign(device, controllerNode);
            controllerNodeDao.update(controllerNode);
            System.out.println("Service层---- 更新控制器" + "\n" + device);
        } else {
            throw new IllegalArgumentException("设备数据非法");
        }
    }

    /**
     * @param device
     * @see IDeviceService
     */
    @Transactional
    @Override
    public void deleteDevice(Object device) {
        if (device == null) {
            throw new IllegalArgumentException("设备数据不能为空");
        }
        //判断device类型（传感器 or 控制器）
        if (device instanceof SensorNode) {
            //传感器
            sensorNodeDao.deleteById(((SensorNode) device).getId());
            System.out.println("Service层---- 移除传感器" + "\n" + "id = " + ((SensorNode) device).getId());
        } else if (device instanceof ControllerNode) {
            //控制器
            controllerNodeDao.deleteById(((ControllerNode) device).getId());
            System.out.println("Service层---- 移除控制器" + "\n" + "id = " + ((ControllerNode) device).getId());
        } else if (device instanceof SensorNodeVo) {
            sensorNodeDao.deleteById(((SensorNodeVo) device).getId());
            System.out.println("Service层---- 移除传感器" + "\n" + "id = " + ((SensorNodeVo) device).getId());
        } else if (device instanceof ControllerNodeVo) {
            controllerNodeDao.deleteById(((ControllerNodeVo) device).getId());
            System.out.println("Service层---- 移除控制器" + "\n" + "id = " + ((ControllerNodeVo) device).getId());
        } else {
            throw new IllegalArgumentException("设备数据非法");
        }
    }

    /**
     * @see IDeviceService
     */
    @Override
    public List<SensorNode> selectAllSensor() {
        System.out.println("Service层---- 查询全部SensorNode");
        return sensorNodeDao.selectAll();
    }

    /**
     * @see IDeviceService
     */
    @Override
    public List<ControllerNode> selectAllController() {
        System.out.println("Service层---- 查询全部ControllerNode");
        return controllerNodeDao.selectAll();
    }

    /**
     * @see IDeviceService
     */
    @Override
    public List<Client> selectAllClient() {
        System.out.println("Service层---- 查询全部Client");
        return clientDao.selectAll();
    }

    /**
     * @see IDeviceService
     */
    @Override
    public List<SensorNode> readSensors(ClientVo clientVo) {
        System.out.println("Service层---- 根据客户端id查询全部SensorNode");
        return sensorNodeDao.selectByClientId(clientVo.getId());
    }

    /**
     * @see IDeviceService
     */
    @Override
    public List<SensorNode> readSensorsByPage(Map<String, Object> item) throws InvocationTargetException, IllegalAccessException {
        System.out.println("Service层---- 分页查询SensorNode");

        Map<String, Object> sqlArgs = new HashMap<>();
        SensorNode sensorNode = new SensorNode();
        Client client = new Client();
        PageModel pageModel = (PageModel) item.get("pageModel");

        //设置参数
        //vo转换
        if (item.get("clientVo") != null) {
            AssignByFieldName.getInstance().Assign(item.get("clientVo"), client);
            sensorNode.setClient(client);
        } else {
            throw new IllegalArgumentException("客户端信息错误");
        }
        sqlArgs.put("sensorNode", sensorNode);

        //判断分页对象是否存在
        if (pageModel != null) {
            //设置查询总记录数
            pageModel.setRecordCount(sensorNodeDao.count(sqlArgs));
        } else {
            throw new IllegalArgumentException("分页信息错误");
        }
        sqlArgs.put("pageModel", pageModel);

        //根据客户端id来查询，返回
        return sensorNodeDao.selectByPage(sqlArgs);
    }

    /**
     * @see IDeviceService
     */
    @Override
    public List<SensorNode> readSensor(SensorNodeVo sensorNodeVo) throws InvocationTargetException, IllegalAccessException {
        System.out.println("Service层---- 查询SensorNode");
        Map<String, Object> sqlArgs = new HashMap<>();
        //vo转换
        SensorNode sensorNode = new SensorNode();
        AssignByFieldName.getInstance().Assign(sensorNodeVo, sensorNode);
        //判断客户端数据
        if (sensorNodeVo.getClientId() != null) {
            Client client = new Client();
            client.setId(sensorNodeVo.getClientId());
            sensorNode.setClient(client);
        }
        sqlArgs.put("sensorNode", sensorNode);
        //查询返回
        return sensorNodeDao.selectByPage(sqlArgs);
    }

    /**
     * @see IDeviceService
     */
    @Override
    public Map<Object, Object> getSensorsDeviceValue(List<ClientVo> clientVos) throws InvocationTargetException, IllegalAccessException, IOException, InterruptedException {
        System.out.println("Service---- 获取传感器数值");
        //TODO -从传感器设备获取数据，2层封装（待优化）（device改变，需要修改）
        List<SensorNodeVo> sensorNodeVos = new ArrayList<>();
        Map<Object, Object> sensorNodesWithValue = new HashMap<>();

        //遍历客户端信息
        for (ClientVo clientVo : clientVos) {
            List<SensorNode> sensorNodes = sensorNodeDao.selectByClientId(clientVo.getId());
            //查询客户端下所有传感器
            for (SensorNode node : sensorNodes) {
                SensorNodeVo sensorNodeVo = new SensorNodeVo();
                //vo转换
                AssignByFieldName.getInstance().Assign(node, sensorNodeVo);
                //获取所有传感器数值
                sensorNodeVo = (SensorNodeVo) device.getSensorValue(sensorNodeVo);
                //插个眼
                sensorNodeVo.setClientId(clientVo.getId());
                sensorNodeVos.add(sensorNodeVo);
            }
            //存入map
            sensorNodesWithValue.put(clientVo, sensorNodeVos);
        }

        //返回
        return sensorNodesWithValue;
    }

    /**
     * @see IDeviceService
     */
    @Override
    public SensorNodeVo getSingleSensor(ClientVo clientVo, Sensor sensor) throws InvocationTargetException, IllegalAccessException {
        System.out.println("Service---- 获取单个传感器");

        Map<String, Object> item = new HashMap<>();
        SensorNode sensorNode = new SensorNode();
        Client client = new Client();
        SensorNodeVo sensorNodeVo = new SensorNodeVo();
        client.setId(clientVo.getId());

        sensorNode.setType(sensor.getType());
        sensorNode.setClient(client);
        item.put("sensorNode", sensorNode);
        List<SensorNode> sensorNodes = sensorNodeDao.selectByPage(item);
        sensorNode = sensorNodes.get(0);
        AssignByFieldName.getInstance().Assign(sensorNode,sensorNodeVo);

//        sensorNodeVo = (SensorNodeVo) device.getSensorValue(sensorNodeVo);

        return sensorNodeVo;

    }

    /**
     * @see IDeviceService
     */
    @Override
    public SensorNodeVo getSingleSensorValue(SensorNodeVo sensorNodeVo) throws IOException, InterruptedException {
        System.out.println("Service---- 读取控制器参数");
        return (SensorNodeVo) device.getSensorValue(sensorNodeVo);
    }

    /**
     * @see IDeviceService
     */
    @Override
    public void determineSensorValue(Map<Object, Object> item) throws Exception {
        System.out.println("Service---- 设置传感器阈值");
        //判断客户端信息
        if (!item.containsKey("clientVo")) {
            throw new IllegalArgumentException("客户端信息非法");
        }
        //判断操作设备类型（使用枚举类）
        //创建控制方案
        //本方法只做任务判断
        Map<Object, Object> humidityScheme = new HashMap<>();
        Map<Object, Object> lightScheme = new HashMap<>();
        Map<Object, Object> smokeAndPM25Scheme = new HashMap<>();
        ControlScheme controlScheme = new ControlScheme(DeviceControlType.ARTIFICIAL, (ClientVo) item.get("clientVo"));

        if (item.containsKey(DeviceControl.LIGHT)) {
            lightScheme.put(DeviceControl.LIGHT, item.get(DeviceControl.LIGHT));
            controlScheme.setLight(lightScheme);
        }
        if (item.containsKey(DeviceControl.CURTAIN)) {
            lightScheme.put(DeviceControl.CURTAIN, item.get(DeviceControl.CURTAIN));
            controlScheme.setLight(lightScheme);
        }
        if (item.containsKey(DeviceControl.AIR_CONDITIONER)) {
            humidityScheme.put(DeviceControl.AIR_CONDITIONER, item.get(DeviceControl.AIR_CONDITIONER));
            //设置方案
            controlScheme.setHumidity(humidityScheme);
        }
        if (item.containsKey(DeviceControl.FAN)) {
            smokeAndPM25Scheme.put(DeviceControl.FAN, item.get(DeviceControl.FAN));
            //设置方案
            controlScheme.setSmokeAndPM25(smokeAndPM25Scheme);
        }
        //调用本类的控制设备方法autoController()---自动响应
        System.out.println("Service---- 方案参数" + "\n" + controlScheme);
        autoControl(controlScheme);

    }

    /**
     * @see IDeviceService
     */
    @Override
    public Object sensorPolice(ClientVo clientVo) {
        device.police(clientVo);
        return null;
    }

    /**
     * @see IDeviceService
     */
    @Override
    public Object sensorZone(ClientVo clientVo) {
        device.zone(clientVo);
        return null;
    }

    /**
     * @see IDeviceService
     */
    @Override
    public List<ControllerNode> readControllerNodes(ClientVo clientVo) {
        System.out.println("Service层---- 根据客户端id查询全部ControllerNode");
        return controllerNodeDao.selectByClientId(clientVo.getId());
    }

    /**
     * @see IDeviceService
     */
    @Override
    public List<ControllerNode> readControllerNodesByPage(Map<String, Object> item) throws InvocationTargetException, IllegalAccessException {
        System.out.println("Service层---- 分页查询ControllerNode");

        Map<String, Object> sqlArgs = new HashMap<>();
        ControllerNode controllerNode = new ControllerNode();
        Client client = new Client();
        PageModel pageModel = (PageModel) item.get("pageModel");

        //设置参数
        //vo转换
        if (item.get("clientVo") != null) {
            AssignByFieldName.getInstance().Assign(item.get("clientVo"), client);
            controllerNode.setClient(client);
        } else {
            throw new IllegalArgumentException("客户端信息错误");
        }
        sqlArgs.put("controllerNode", controllerNode);

        //判断分页对象是否存在
        if (pageModel != null) {
            //设置查询总记录数
            pageModel.setRecordCount(controllerNodeDao.count(sqlArgs));
        } else {
            throw new IllegalArgumentException("分页信息错误");
        }
        sqlArgs.put("pageModel", pageModel);

        //根据客户端id来查询，返回
        return controllerNodeDao.selectByPage(sqlArgs);
    }

    /**
     * @see IDeviceService
     */
    @Override
    public List<ControllerNode> readControllerNode(ControllerNodeVo controllerNodeVo) throws InvocationTargetException, IllegalAccessException {
        System.out.println("Service层---- 查询SensorNode");
        Map<String, Object> sqlArgs = new HashMap<>();
        //vo转换
        ControllerNode controllerNode = new ControllerNode();
        AssignByFieldName.getInstance().Assign(controllerNodeVo, controllerNode);
        //判断客户端数据
        if (controllerNodeVo.getClientId() != null) {
            Client client = new Client();
            client.setId(controllerNodeVo.getClientId());
            controllerNode.setClient(client);
        }
        sqlArgs.put("controllerNode", controllerNode);
        //查询返回
        return controllerNodeDao.selectByPage(sqlArgs);
    }

    /**
     * @see IDeviceService
     */
    @Override
    public ControllerNodeVo getSingleControllerNode(ClientVo clientVo, DeviceControl device) throws InvocationTargetException, IllegalAccessException {
        System.out.println("Service---- 获取单个控制器节点");

        Map<String, Object> item = new HashMap<>();
        ControllerNode controllerNode = new ControllerNode();
        Client client = new Client();
        ControllerNodeVo controllerNodeVo = new ControllerNodeVo();
        client.setId(clientVo.getId());

        controllerNode.setType(device.getType());
        controllerNode.setClient(client);
        item.put("controllerNode", controllerNode);
        List<ControllerNode> controllerNodes = controllerNodeDao.selectByPage(item);
        controllerNode = controllerNodes.get(0);
        AssignByFieldName.getInstance().Assign(controllerNode,controllerNodeVo);

        return controllerNodeVo;
    }

    @Override
    public ControllerNodeVo getSingleControllerNodeValue(ControllerNodeVo controllerNodeVo) {
        System.out.println("Service---- 获取单个控制器节点数值");
        return (ControllerNodeVo) device.readController(controllerNodeVo);
    }

    /**
     * @see IDeviceService
     */
    @Override
    public void deviceControl(Map<String, Object> item) {
        System.out.println("Service---- 控制控制器");
        //根据客户端信息，查询控制器（略）

        //判断数据
        if (!item.containsKey("controllerNodeVo")) {
            throw new IllegalArgumentException("未指定控制器信息");
        }
        if (!item.containsKey("deviceControl")) {
            throw new IllegalArgumentException("未指定设备控制类型");
        }
        if (!item.containsKey("deviceControlType")) {
            throw new IllegalArgumentException("未指定设备操作");
        }
        ControllerNodeVo controllerNodeVo = (ControllerNodeVo) item.get("controllerNodeVo");
        //控制控制器
        switch ((DeviceControl)item.get("deviceControl")) {
            case LIGHT :
                String light_type = ((Light) item.get("deviceControlType")).getCmd();
                //设置控制代码
                controllerNodeVo.setControlCode(light_type);
                //调用控制服务类
                device.control(controllerNodeVo);
            case FAN :
                String fan_type = ((Fan) item.get("deviceControlType")).getCmd();
                controllerNodeVo.setControlCode(fan_type);
                device.control(controllerNodeVo);
            case CURTAIN :
                String curtain_type = ((Curtain) item.get("deviceControlType")).getCmd();
                controllerNodeVo.setControlCode(curtain_type);
                device.control(controllerNodeVo);
            case AIR_CONDITIONER :
                String ac_type = ((AirConditioner) item.get("deviceControlType")).getCmd();
                controllerNodeVo.setControlCode(ac_type);
                device.control(controllerNodeVo);
            default :
                break;
        }

    }

    /**
     * @see IDeviceService
     */
    @Override
    public void autoControl(ControlScheme controlScheme) throws Exception {
        System.out.println("Service---- 开启环境自动响应");
        System.out.println(controlScheme);

        //（每秒监听传感器数值）（死循环？）（开关功能）（设置系统默认与手动设置的转换）

        //按照客户端查询，分别查出各个传感器，放在独立的容器
        SensorNodeVo humiditySensor = getSingleSensor(controlScheme.getClientVo(), Sensor.HUMIDITY);
        SensorNodeVo smokeSensor = getSingleSensor(controlScheme.getClientVo(), Sensor.SMOKE);
        SensorNodeVo lightSensor = getSingleSensor(controlScheme.getClientVo(), Sensor.LIGHT);
        SensorNodeVo pm25Sensor = getSingleSensor(controlScheme.getClientVo(), Sensor.PM25);
        //分别查出4个控制器的vo
        ControllerNodeVo ac = getSingleControllerNode(controlScheme.getClientVo(), DeviceControl.AIR_CONDITIONER);
        ControllerNodeVo fan = getSingleControllerNode(controlScheme.getClientVo(), DeviceControl.FAN);
        ControllerNodeVo curtain = getSingleControllerNode(controlScheme.getClientVo(), DeviceControl.CURTAIN);
        ControllerNodeVo light = getSingleControllerNode(controlScheme.getClientVo(), DeviceControl.LIGHT);

        //开关控制，方案切换

        //取得其中需要判断数值的传感器
        //温湿度 --> 空调
        //光照度 --> 窗帘、照明
        //PM2.5、烟雾 --> 风扇

        //判断方案中对应的数据是否存在,并开启自动响应（开启线程？）
        //温湿度 --> 空调
        if (controlScheme.getHumidity() != null) {
            humidity_autoControl(controlScheme.getClientVo(), controlScheme.getHumidity(),
                    humiditySensor, ac);
        }
        //光照度 --> 窗帘、照明
        if (controlScheme.getLight() != null) {
            light_autoControl(controlScheme.getClientVo(), controlScheme.getLight(),
                    lightSensor, light, curtain);
        }
        //PM2.5、烟雾 --> 风扇
        if (controlScheme.getSmokeAndPM25() != null) {
            smokeAndPM25_autoControl(controlScheme.getClientVo(), controlScheme.getSmokeAndPM25(),
                    smokeSensor, pm25Sensor, fan);
        }

        //判断操作类型，调用deviceControl()传到Device（参数看上一个方法）（转到对应方法内）

        //从参数中获取预设方案（转到对应方法内）

    }

    /**
     * @see IDeviceService
     */
    @Override
    public void humidity_autoControl(ClientVo clientVo, Map<Object, Object> value, SensorNodeVo humiditySensor, ControllerNodeVo ac) throws Exception {
        System.out.println("Service---- 启用温湿度自动响应");

        new Thread(() -> {
            while (true) {
                //获取节点数据（温湿度传感器-空调）
                SensorNodeVo humiditySensorWhitValue = null;
                try {
                    humiditySensorWhitValue = getSingleSensorValue(humiditySensor);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(humiditySensorWhitValue);

                //获取任务方案，解析对应的方案map
                //map结构为，枚举操作类型-长度为2的String数组，0为低值，1为高值
                String[] schemeValue = (String[]) value.get(DeviceControl.AIR_CONDITIONER);

                //设置方案
                //TODO -控制代码待完善
                if (Integer.parseInt(humiditySensorWhitValue.getValue()) < Integer.parseInt(schemeValue[0])) {
                    //小于低值，调高温度
                    ac.setControlCode(AirConditioner.TEMPERATURE.getCmd());
                    device.control(ac);
                } else if (Integer.parseInt(humiditySensorWhitValue.getValue()) > Integer.parseInt(schemeValue[1])) {
                    //大于低值，调低温度
                    ac.setControlCode(AirConditioner.TEMPERATURE.getCmd());
                    device.control(ac);
                }

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    /**
     * @see IDeviceService
     */
    @Override
    public void smokeAndPM25_autoControl(ClientVo clientVo, Map<Object, Object> value, SensorNodeVo smokeSensor, SensorNodeVo pm25Sensor, ControllerNodeVo fan)  throws Exception {
        System.out.println("Service---- 启用烟雾与PM2.5自动响应");

        new Thread(() -> {
            while (true) {
                //获取节点数据（烟雾和PM2.5传感器-风扇）
                SensorNodeVo smokeSensorWithValue = null;
                SensorNodeVo pm25SensorWithValue = null;
                try {
                    smokeSensorWithValue = getSingleSensorValue(smokeSensor);
                    pm25SensorWithValue = getSingleSensorValue(pm25Sensor);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(smokeSensorWithValue + "\n" + pm25SensorWithValue);

                //获取任务方案，解析对应的方案map
                //map结构为，枚举操作类型-长度为2的String数组，0为低值，1为高值
                String[] schemeValue = (String[]) value.get(DeviceControl.FAN);

                //设置方案
                if (Integer.parseInt(smokeSensorWithValue.getValue()) < Integer.parseInt(schemeValue[0])) {
                    //小于低值，关风扇
                    fan.setControlCode(Fan.CLOSE.getCmd());
                    device.control(fan);
                } else if (Integer.parseInt(smokeSensorWithValue.getValue()) > Integer.parseInt(schemeValue[1])) {
                    //大于低值，开风扇
                    fan.setControlCode(Fan.STEP_ONE.getCmd());
                    device.control(fan);
                } else {
                    continue;
                }
                if (Integer.parseInt(pm25SensorWithValue.getValue()) < Integer.parseInt(schemeValue[0])) {
                    fan.setControlCode(Fan.CLOSE.getCmd());
                    device.control(fan);
                } else if (Integer.parseInt(pm25SensorWithValue.getValue()) > Integer.parseInt(schemeValue[1])) {
                    fan.setControlCode(Fan.STEP_ONE.getCmd());
                    device.control(fan);
                }

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    /**
     * @see IDeviceService
     */
    @Override
    public void light_autoControl(ClientVo clientVo, Map<Object, Object> value, SensorNodeVo lightSensor, ControllerNodeVo light, ControllerNodeVo curtain)  throws Exception {
        System.out.println("Service---- 启用光照度自动响应");

        new Thread(() -> {
            while (true) {
                //获取节点数据（光照传感器-窗帘和照明）
                SensorNodeVo lightSensorWithVale = null;
                try {
                    lightSensorWithVale = getSingleSensorValue(lightSensor);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(lightSensorWithVale);

                //获取任务方案，解析对应的方案map
                //map结构为，枚举操作类型-长度为2的String数组，0为低值，1为高值
                String[] curtainSchemeValue = (String[]) value.get(DeviceControl.CURTAIN);
                String[] lightSchemeValue = (String[]) value.get(DeviceControl.LIGHT);

                //设置方案
                if (Integer.parseInt(lightSensorWithVale.getValue()) < Integer.parseInt(curtainSchemeValue[0])) {
                    //小于低值，打开窗帘
                    curtain.setControlCode(Curtain.FULL.getCmd());
                    device.control(curtain);
                } else if (Integer.parseInt(lightSensorWithVale.getValue()) > Integer.parseInt(curtainSchemeValue[1])) {
                    //大于低值，拉上窗帘
                    curtain.setControlCode(Curtain.CLOSE.getCmd());
                    device.control(curtain);
                }
                if (Integer.parseInt(lightSensorWithVale.getValue()) < Integer.parseInt(lightSchemeValue[0])) {
                    //小于低值，开灯
                    light.setControlCode(Light.ON.getCmd());
                    device.control(light);
                } else if (Integer.parseInt(lightSensorWithVale.getValue()) > Integer.parseInt(lightSchemeValue[1])) {
                    //大于低值，关灯
                    light.setControlCode(Light.OFF.getCmd());
                    device.control(light);
                }

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    /**
     * @see IDeviceService
     */
    @Override
    public void contingencyPlan(ControllerNodeVo ControllerNodeVo) {

    }
}
