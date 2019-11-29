package org.zhl.scs.service;

import io.netty.channel.Channel;
import io.netty.channel.pool.FixedChannelPool;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import org.junit.Test;
import org.zhl.scs.service.device.monitor.MonitorServer;
import org.zhl.scs.service.device.monitor.Monitoring;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class DeviceTest {

    //模拟传感器中控读取参数
    @Test
    public void deviceServer() throws IOException {
        //指定监听端口
        int value;
        int port = 55533;
        ServerSocket server = new ServerSocket(port);
        System.out.println("服务器开启");

        /*while (true) {
            Socket socket = server.accept();
            //建立连接后，从socket中获取输入流，并建立缓冲区进行读取
            *//*InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            StringBuilder sb = new StringBuilder();
            while ((len = inputStream.read(bytes)) != -1) {
                //编码格式双方要一致
//                sb.append(new String(bytes, 0, len, StandardCharsets.UTF_8));
                System.out.println("从传感器客户端获取的信息：" + new String(bytes, 0, len));
                value = Integer.parseInt(new String(bytes, 0, len));

                OutputStream outputStream = socket.getOutputStream();
                //String msg = "ok";
                //byte[] re = msg.getBytes();
                outputStream.write(value);
                outputStream.flush();
            }*//*

            OutputStream outputStream = socket.getOutputStream();
            //String msg = "ok";
            //byte[] re = msg.getBytes();
            outputStream.write("20".getBytes());
            outputStream.flush();

            //inputStream.close();
            socket.close();
        }*/

        Socket socket = server.accept();
        //建立连接后，从socket中获取输入流，并建立缓冲区进行读取
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        len = inputStream.read(bytes);
        System.out.println("从传感器客户端获取的信息：" + new String(bytes, 0, len));

        inputStream.close();
        socket.close();

    }
    //模拟持续读取传感器数值
    @Test
    public void getDeviceValue() throws IOException {

        String host = "127.0.0.1";
        int port = 55532;
        Socket socket = new Socket(host, port);
        System.out.println("模拟Device获取传感器数值，客户端开启----");

        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        StringBuilder sb = new StringBuilder();
        while ((len = inputStream.read(bytes)) != -1) {
            //编码格式双方要一致
//                sb.append(new String(bytes, 0, len, StandardCharsets.UTF_8));
            System.out.println("从中控中心获取传感器的信息：" + new String(bytes, 0, len));
        }
        /*len = inputStream.read(bytes);
        System.out.println("从中控中心获取传感器的信息：" + new String(bytes, 0, len));*/

        inputStream.close();
        socket.close();
    }

    @Test
    public void serverTest() throws InterruptedException {
        new MonitorServer(7777).run();
    }

    @Test
    public void clientTest() throws InterruptedException {
        Monitoring monitoring = new Monitoring();
        monitoring.run();
        FixedChannelPool pool = monitoring.getFixedChannelPool();
        Future<Channel> acquire = pool.acquire();
        acquire.addListener((FutureListener<Channel>) future -> {
            if (future.isSuccess()) {
                //监听传值
                Channel channel = future.getNow();
                //触发读
                //channel.writeAndFlush("hello");
                channel.read();
                //回收
                pool.release(channel);
            }
        });
        Thread.sleep(15000);

    }

}
