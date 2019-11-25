package org.zhl.scs.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zhl.scs.Application;
import org.zhl.scs.domain.Client;
import org.zhl.scs.domain.ControllerNode;
import org.zhl.scs.domain.SensorNode;
import org.zhl.scs.domain.vo.ClientVo;
import org.zhl.scs.domain.vo.ControllerNodeVo;
import org.zhl.scs.domain.vo.SensorNodeVo;
import org.zhl.scs.service.device.Device;
import org.zhl.scs.service.device.IDeviceService;
import org.zhl.scs.util.AssignByFieldName;
import org.zhl.scs.util.PageModel;
import org.zhl.scs.util.common.devices.AirConditioner;
import org.zhl.scs.util.common.devices.DeviceControl;
import org.zhl.scs.util.common.devices.Sensor;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * 设备管理单元测试类
 *
 * @author lzs
 * @version v1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class DeviceServiceImplTest {

    @Autowired
    private IDeviceService deviceService;
    @Autowired
    private Device device;

    //测试Service层 saveDevice方法（SensorNode）
    @Test
    public void saveSensorNode() throws InvocationTargetException, IllegalAccessException {
        //模拟controller层传入数据 + 模拟controller层vo转po
        SensorNodeVo sensorNodeVo = new SensorNodeVo();
        sensorNodeVo.setCode("zhl04002smoke001");
        sensorNodeVo.setTime(new Date());
        sensorNodeVo.setType("烟雾传感器");
        sensorNodeVo.setStatus("enable");
        sensorNodeVo.setFundescription("监控环境烟雾浓度");
        sensorNodeVo.setAddress("zhl04002");
        sensorNodeVo.setFlag("XXX");
        sensorNodeVo.setClientId(1);

        SensorNode sensorNode = new SensorNode();
        AssignByFieldName.getInstance().Assign(sensorNodeVo, sensorNode);
        //设置客户端
        Client client = new Client();
        client.setId(sensorNodeVo.getClientId());
        sensorNode.setClient(client);

        System.out.println("----controller层---- 传入参数SensorNode" + "\n" + sensorNode);

        //调用service层方法
        deviceService.saveDevice(sensorNode);

        //返回给controller层数据
        System.out.println("----返回controller层---- ");
    }

    //测试Service层 saveDevice方法（ControllerNode）
    @Test
    public void saveControllerNode() throws InvocationTargetException, IllegalAccessException {
        //模拟controller层传入数据 + 模拟controller层vo转po
        ControllerNodeVo controllerNodeVo = new ControllerNodeVo();
        controllerNodeVo.setCode("zhl04002light001");
        controllerNodeVo.setTime(new Date());
        controllerNodeVo.setType("灯光照明");
        controllerNodeVo.setStatus("enable");
        controllerNodeVo.setValue("100");
        controllerNodeVo.setAddress("zhl04002");
        controllerNodeVo.setFlag("xxx");
        controllerNodeVo.setClientId(1);

        ControllerNode controllerNode = new ControllerNode();
        AssignByFieldName.getInstance().Assign(controllerNodeVo, controllerNode);

        System.out.println("----controller层---- 传入参数SensorNode" + "\n" + controllerNode);
        //设置客户端
        Client client = new Client();
        client.setId(controllerNodeVo.getClientId());
        controllerNode.setClient(client);

        //调用service层方法
        deviceService.saveDevice(controllerNode);

        //返回给controller层数据
        System.out.println("----返回controller层---- ");
    }

    //测试Service层 updateDevice方法（SensorNode）
    @Test
    public void updateSensorNode() {
        //省略查询过程，省略vo转po，假设已经经过查询获得id索引
        //模拟controller层传入参数
        SensorNode sensorNode = new SensorNode();
        sensorNode.setId(1);
        //模拟设置更新值
        sensorNode.setStatus("enable");

        System.out.println("----controller层---- 传入参数SensorNode" + "\n" + sensorNode);
        //调用service层方法
        deviceService.updateDevice(sensorNode);

        //返回给controller层数据
        System.out.println("----返回controller层---- ");
    }

    //测试Service层 updateDevice方法（ControllerNode）
    @Test
    public void updateControllerNode() {
        //省略查询过程，省略vo转po，假设已经经过查询获得id索引
        //模拟controller层传入参数
        ControllerNode controllerNode = new ControllerNode();
        controllerNode.setId(4);
        //模拟设置更新值
        controllerNode.setValue("0");

        System.out.println("----controller层---- 传入参数SensorNode" + "\n" + controllerNode);
        //调用service层方法
        deviceService.updateDevice(controllerNode);

        //返回给controller层数据
        System.out.println("----返回controller层---- ");
    }

    //测试Service层 deleteDevice方法（SensorNode）
    @Test
    public void deleteSensorNode() {
        //省略查询过程，省略vo转po，假设已经经过查询获得id索引
        //模拟controller层传入参数
        SensorNode sensorNode = new SensorNode();
        sensorNode.setId(3);

        System.out.println("----controller层---- 传入参数SensorNode" + "\n" + sensorNode);
        //调用service层方法
        deviceService.deleteDevice(sensorNode);

        //返回给controller层数据
        System.out.println("----返回controller层---- ");
    }

    //测试Service层 deleteDevice方法（ControllerNode）
    @Test
    public void deleteControllerNode() {
        //省略查询过程，省略vo转po，假设已经经过查询获得id索引
        //模拟controller层传入参数
        ControllerNode controllerNode = new ControllerNode();
        controllerNode.setId(4);

        System.out.println("----controller层---- 传入参数SensorNode" + "\n" + controllerNode);
        //调用service层方法
//        deviceService.deleteDevice(controllerNode);

        //返回给controller层数据
        System.out.println("----返回controller层---- ");
    }

    //测试Service层 selectAllSensor方法
    @Test
    public void selectAllSensor() {
        //模拟controller层传入参数

        //调用service层方法
        List<SensorNode> sensorNodes = deviceService.selectAllSensor();

        //返回给controller层数据
        System.out.println("----返回controller层---- 返回值List<SensorNode>");
        for (SensorNode sensorNode : sensorNodes) {
            System.out.println(sensorNode);
        }
    }

    //测试Service层 selectAllController方法
    @Test
    public void selectAllController() {
        //模拟controller层传入参数

        //调用service层方法
        List<ControllerNode> controllerNodes = deviceService.selectAllController();

        //返回给controller层数据
        System.out.println("----返回controller层---- 返回值List<ControllerNode>");
        for (ControllerNode controllerNode : controllerNodes) {
            System.out.println(controllerNode);
        }
    }

    //测试Service层 readSensors方法
    @Test
    public void readSensors() {
        //模拟controller层传入参数
        ClientVo clientVo = new ClientVo();
        clientVo.setId(1);

        System.out.println("----controller层---- 传入参数clientVo" + "\n" + clientVo);
        //调用service层方法
        List<SensorNode> sensorNodes = deviceService.readSensors(clientVo);

        //返回给controller层数据
        System.out.println("----返回controller层---- 返回值List<SensorNode>");
        for (SensorNode sensorNode : sensorNodes) {
            System.out.println(sensorNode);
        }
    }

    //测试Service层 readSensorByPage方法
    @Test
    public void readSensorByPage() throws InvocationTargetException, IllegalAccessException {
        //模拟controller层传入参数
        Map<String, Object> args = new HashMap<>();
        PageModel pageModel = new PageModel();
        ClientVo clientVo = new ClientVo();
        //初始分页，模拟从第一页开始查询，测试每页两条数据
        pageModel.setPageIndex(1);
        //模拟已经经过查询获得主键id
        clientVo.setId(1);
        args.put("clientVo", clientVo);
        args.put("pageModel", pageModel);

        System.out.println("----controller层---- 传入参数clientVo" + "\n" + args);

        //模拟分页查询，第一页
        List<SensorNode> sensorNodes = new ArrayList<>();
        //调用service层方法
        sensorNodes = deviceService.readSensorsByPage(args);

        System.out.println("----返回controller层---- 模拟分页查询");
        //返回给controller层数据
        System.out.println("----返回controller层---- --第一页-- 返回值List<SensorNode>");
        for (SensorNode sensorNode : sensorNodes) {
            System.out.println(sensorNode);
        }

        //第二页
        pageModel.setPageIndex(2);
        args.put("pageModel", pageModel);
        //调用service层方法
        sensorNodes = deviceService.readSensorsByPage(args);

        System.out.println("----返回controller层---- 模拟分页查询");
        //返回给controller层数据
        System.out.println("----返回controller层---- --第二页-- 返回值List<SensorNode>");
        for (SensorNode sensorNode : sensorNodes) {
            System.out.println(sensorNode);
        }

        //第三页
        pageModel.setPageIndex(3);
        args.put("pageModel", pageModel);
        //调用service层方法
        sensorNodes = deviceService.readSensorsByPage(args);

        System.out.println("----返回controller层---- 模拟分页查询");
        //返回给controller层数据
        System.out.println("----返回controller层---- --第三页-- 返回值List<SensorNode>");
        for (SensorNode sensorNode : sensorNodes) {
            System.out.println(sensorNode);
        }
    }

    //测试Service层 readSensor方法
    @Test
    public void readSensor() throws InvocationTargetException, IllegalAccessException {
        //模拟controller层传入参数
        SensorNodeVo sensorNodeVo = new SensorNodeVo();
        //模拟查询传值
//        sensorNodeVo.setCode("zhl04002air001");
        sensorNodeVo.setClientId(1);
        //测试模糊查询
        sensorNodeVo.setType("空气");

        System.out.println("----controller层---- 传入参数sensorNodeVo" + "\n" + sensorNodeVo);
        //调用service层方法
        List<SensorNode> sensorNodes = deviceService.readSensor(sensorNodeVo);

        //返回给controller层数据
        System.out.println("----返回controller层---- 返回值List<SensorNode>");
        for (SensorNode sensorNode : sensorNodes) {
            System.out.println(sensorNode);
        }
    }


    //测试Service层 readControllerNodes方法
    @Test
    public void readControllerNodes() {
        //模拟controller层传入参数
        ClientVo clientVo = new ClientVo();
        clientVo.setId(1);

        System.out.println("----controller层---- 传入参数clientVo" + "\n" + clientVo);
        //调用service层方法
        List<ControllerNode> controllerNodes = deviceService.readControllerNodes(clientVo);

        //返回给controller层数据
        System.out.println("----返回controller层---- 返回值List<ControllerNode>");
        for (ControllerNode controllerNode : controllerNodes) {
            System.out.println(controllerNode);
        }
    }

    //测试Service层 readControllerNodesByPage方法
    @Test
    public void readControllerNodesByPage() throws InvocationTargetException, IllegalAccessException {
        //模拟controller层传入参数
        Map<String, Object> args = new HashMap<>();
        PageModel pageModel = new PageModel();
        ClientVo clientVo = new ClientVo();
        //初始分页，模拟从第一页开始查询，测试每页两条数据
        pageModel.setPageIndex(1);
        //模拟已经经过查询获得主键id
        clientVo.setId(1);
        args.put("clientVo", clientVo);
        args.put("pageModel", pageModel);

        System.out.println("----controller层---- 传入参数clientVo" + "\n" + args);

        //模拟分页查询，第一页
        List<ControllerNode> controllerNodes = new ArrayList<>();
        //调用service层方法
        controllerNodes = deviceService.readControllerNodesByPage(args);

        System.out.println("----返回controller层---- 模拟分页查询");
        //返回给controller层数据
        System.out.println("----返回controller层---- --第一页-- 返回值List<SensorNode>");
        for (ControllerNode controllerNode : controllerNodes) {
            System.out.println(controllerNode);
        }

        //第二页
        pageModel.setPageIndex(2);
        args.put("pageModel", pageModel);
        //调用service层方法
        controllerNodes = deviceService.readControllerNodesByPage(args);
        //返回给controller层数据
        System.out.println("----返回controller层---- --第二页-- 返回值List<SensorNode>");
        for (ControllerNode controllerNode : controllerNodes) {
            System.out.println(controllerNode);
        }
    }

    //测试Service层 readControllerNode方法
    @Test
    public void readControllerNode() throws InvocationTargetException, IllegalAccessException {
        //模拟controller层传入参数
        ControllerNodeVo controllerNodeVo = new ControllerNodeVo();
        //模拟查询传值
//        controllerNodeVo.setCode("zhl04002kt001");
        controllerNodeVo.setClientId(1);
        //测试模糊查询
        controllerNodeVo.setType("空调");

        System.out.println("----controller层---- 传入参数sensorNodeVo" + "\n" + controllerNodeVo);
        //调用service层方法
        List<ControllerNode> controllerNodes = deviceService.readControllerNode(controllerNodeVo);

        //返回给controller层数据
        System.out.println("----返回controller层---- 返回值List<ControllerNode>");
        for (ControllerNode controllerNode : controllerNodes) {
            System.out.println(controllerNode);
        }
    }

    //测试Service层 getSensorDeviceValue方法
    @Test
    public void getSensorsDeviceValue() throws InvocationTargetException, IllegalAccessException, IOException {
        //获取设备数据
        //可以传入一个或者多个客户端

        //模拟controller层操作&传入参数
        List<ClientVo> clientVos = new ArrayList<>();
        ClientVo clientVo1 = new ClientVo();
        clientVo1.setId(1);
        ClientVo clientVo2 = new ClientVo();
        clientVo2.setId(2);
        clientVos.add(clientVo1);
        clientVos.add(clientVo2);

        System.out.println("----controller层---- 传入参数clientVos" + "\n" + clientVos);
        /*//test
        Timer timer = new Timer();
        new TimerTask() {
            @Override
            public void run() {

            }
        };*/
        //调用service层方法
        Map<Object, Object> sensorDeviceValue = deviceService.getSensorsDeviceValue(clientVos);

        //返回给controller层数据
        System.out.println("----返回controller层---- 返回值Map<Object, Object>");
        for (Map.Entry<Object, Object> entry : sensorDeviceValue.entrySet()) {
            System.out.println("clientVO---- " + entry.getKey() + "\n" +
                    "SensorNode---- " + entry.getValue());
        }
    }

    //测试Service层 determineSensorValue方法
    @Test
    public void determineSensorValue() throws Exception {
        //获取当前客户端信息
        //以客户端信息获取设备数据
        //判断数据，采取措施

        //模拟controller层操作&传入参数
        Map<Object, Object> item = new HashMap<>();
        ClientVo clientVo = new ClientVo();
        clientVo.setId(1);
        item.put("clientVo", clientVo);
        //item.put(DeviceControl.LIGHT, new String[]{"50", "90"}); //光照
        item.put(DeviceControl.AIR_CONDITIONER, new String[]{"24", "26"}); //环境温度
        //item.put(DeviceControl.CURTAIN, new String[]{"90", "50"}); //光照
        //item.put(DeviceControl.FAN, new String[]{"1", "1"}); //PM2.5、烟雾？

        System.out.println("----controller层---- 传入参数Map<Object, Object>" + "\n" + item);
        //调用service层方法
        deviceService.determineSensorValue(item);

        //返回给controller层数据
        System.out.println("----返回controller层---- ");

        //看效果
        Thread.sleep(20000);
    }

    //测试Service层 deviceControl方法
    @Test
    public void deviceControl() {
        //页面后台对应4个方法，照明控制参数，风扇控制参数，空调控制参数，窗帘控制参数（可以为null）
        //假设页面绑定了客户端id，设备id
        //s层传入controllerVo，设备类型？，操作类型，操做数值
        //传入Map<Object, Object>

        //模拟controller层操作&传入参数
        Map<String, Object> item = new HashMap<>();
        ControllerNodeVo controllerNodeVo = new ControllerNodeVo();
        controllerNodeVo.setId(1);
        item.put("controllerNodeVo", controllerNodeVo);
        item.put("deviceControl", DeviceControl.AIR_CONDITIONER);
        item.put("deviceControlType", AirConditioner.ADD_OXYGEN);

        System.out.println("----controller层---- 传入参数Map<String, Object>" + "\n" + item);
        //调用service层方法
        deviceService.deviceControl(item);

        //返回给controller层数据
        System.out.println("----返回controller层---- ");
    }

    //测试Service层 autoControl方法
    @Test
    public void autoControl() {
        //

        //模拟controller层操作&传入参数

        //调用service层方法

        //返回给controller层数据
    }

    //测试Service层 getSingleSensorValue方法
    @Test
    public void getSingleSensor() throws InvocationTargetException, IllegalAccessException {

        //模拟controller层操作&传入参数
        ClientVo clientVo = new ClientVo();
        clientVo.setId(1);

        System.out.println("----controller层---- 传入参数clientVo" + "\n" + clientVo);
        //调用service层方法
        SensorNodeVo sensorNodeVo = deviceService.getSingleSensor(clientVo, Sensor.HUMIDITY);

        //返回给controller层数据
        System.out.println("----返回controller层---- 返回值sensorNodeVo" + "\n" + sensorNodeVo);
    }

    //测试Service层 getSingleControllerNode方法
    @Test
    public void getSingleControllerNode() throws InvocationTargetException, IllegalAccessException {
        //模拟controller层操作&传入参数
        ClientVo clientVo = new ClientVo();
        clientVo.setId(1);

        System.out.println("----controller层---- 传入参数clientVo" + "\n" + clientVo);
        //调用service层方法
        ControllerNodeVo controllerNodeVo = deviceService.getSingleControllerNode(clientVo, DeviceControl.AIR_CONDITIONER);

        //返回给controller层数据
        System.out.println("----返回controller层---- 返回值controllerNodeVo" + "\n" + controllerNodeVo);
    }

    //模拟传感器中控读取参数
    @Test
    public void deviceServer() throws IOException {
        //指定监听端口
        String value;
        int port = 55533;
        ServerSocket server = new ServerSocket(port);
        System.out.println("服务器开启");

        while (true) {
            Socket socket = server.accept();
            //建立连接后，从socket中获取输入流，并建立缓冲区进行读取
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            StringBuilder sb = new StringBuilder();

            while ((len = inputStream.read(bytes)) != -1) {
                //编码格式双方要一致
//                sb.append(new String(bytes, 0, len, StandardCharsets.UTF_8));
                System.out.println("从传感器客户端获取的信息：" + new String(bytes, 0, len));

                value = new String(bytes, 0, len);

                SensorNodeVo sensorNodeVo = new SensorNodeVo();
                sensorNodeVo.setValue(value);
                device.getSensorValue(sensorNodeVo);

            }


            inputStream.close();
            socket.close();
        }

    }
    //模拟持续读取单个传感器数值
    @Test
    public void getSingleSensorValue() throws InvocationTargetException, IllegalAccessException, InterruptedException {
        ClientVo clientVo = new ClientVo();
        clientVo.setId(1);
        SensorNodeVo huSensor = deviceService.getSingleSensor(clientVo, Sensor.HUMIDITY);
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                try {
                    device.getSensorValue(huSensor);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        timer.schedule(timerTask, 0, 5000);

        Thread.sleep(30000);
    }
}
