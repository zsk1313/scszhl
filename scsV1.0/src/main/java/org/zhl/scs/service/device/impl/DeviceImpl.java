package org.zhl.scs.service.device.impl;

import io.netty.channel.Channel;
import io.netty.channel.pool.FixedChannelPool;
import io.netty.channel.pool.SimpleChannelPool;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import org.springframework.stereotype.Service;
import org.zhl.scs.domain.vo.ClientVo;
import org.zhl.scs.domain.vo.ControllerNodeVo;
import org.zhl.scs.domain.vo.SensorNodeVo;
import org.zhl.scs.service.device.Device;
import org.zhl.scs.service.device.monitor.Monitoring;
import org.zhl.scs.util.DeviceUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 物理设备接口实现类
 * @author lzs
 * @version v1.0
 */
@Service
public class DeviceImpl implements Device {

    private Map<String, Monitoring> monitoringMap = new HashMap<>();

    /**
     * @see Device
     */
    @Override
    public Object getSensorValue(SensorNodeVo sensorNodeVo) throws IOException, InterruptedException {
        //TODO -从硬件设备接口获取传感器数值
        //该方法可以分成两个，一个只读取一次，一个死循环不断读取，看服务端的编写

        //test

       /* int port = 55532;
        String host = "127.0.0.1";
        Socket socket = new Socket(host, port);
        System.out.println("模拟Device获取传感器数值，客户端开启----");

        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len;

        len = inputStream.read(bytes);
        System.out.println("从中控中心获取传感器的信息：" + new String(bytes, 0, len));
        String value = new String(bytes, 0, len);



        System.out.println("Device---- 发送设备数据");
        //模拟设置数值（test）
        sensorNodeVo.setValue(value);
        System.out.println("Device---- 传感器信息：" + sensorNodeVo);

        inputStream.close();
        socket.close();*/

       //test
        if (sensorNodeVo.getClientId() == null) {
            throw new IllegalArgumentException("客户端id不能为空");
        }
        Monitoring monitoring = null;
        String cid = sensorNodeVo.getClientId().toString();
        if (monitoringMap.containsKey(cid)) {
            monitoring = monitoringMap.get(cid);
        } else {
            monitoring = new Monitoring();
            monitoring.run();
            monitoringMap.put(cid, monitoring);
        }

//        SimpleChannelPool pool = monitoring.getPoolMap().get(Monitoring.serverAddr);
        FixedChannelPool pool = monitoring.getFixedChannelPool();
        Future<Channel> acquire = pool.acquire();
        acquire.addListener((FutureListener<Channel>) future -> {
            if (future.isSuccess()) {
                //监听传值
                Channel channel = future.getNow();
                //触发读
                channel.read();
                //回收
                pool.release(channel);
            }
        });

        return sensorNodeVo;
    }

    /**
     * @see Device
     */
    @Override
    public Object police(ClientVo clientVo) {
        System.out.println("Device---- 向设备发送报警信号");
        System.out.println("Device---- 客户端号" + clientVo);
        return null;
    }

    /**
     * @see Device
     */
    @Override
    public Object zone(ClientVo clientVo) {
        System.out.println("Device---- 向设备发送排险信号");
        System.out.println("Device---- 客户端号" + clientVo);
        return null;
    }

    /**
     * @see Device
     */
    @Override
    public Object control(ControllerNodeVo controllerNodeVo) {
        System.out.println("Device---- 控制控制器");
        controllerNodeVo.setValue("20");
        System.out.println("Device---- 控制器信息：" + controllerNodeVo);
        System.out.println("Device---- 控制器修改成功");
        //转换16进制数指令
        byte[] code = DeviceUtils.stringToByte(controllerNodeVo.getControlCode());
        System.out.println(Arrays.toString(code));
        return null;
    }

    @Override
    public Object readController(ControllerNodeVo controllerNodeVo) {
        System.out.println("Device---- 读取控制器参数");
        controllerNodeVo.setValue("20");
        System.out.println("Device---- 客户端号" + controllerNodeVo);
        return null;
    }

}
