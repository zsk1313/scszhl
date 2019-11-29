package org.zhl.scs.service.device.monitor;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.pool.AbstractChannelPoolMap;
import io.netty.channel.pool.ChannelPoolMap;
import io.netty.channel.pool.FixedChannelPool;
import io.netty.channel.pool.SimpleChannelPool;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;
import java.util.concurrent.locks.LockSupport;

/**
 * 监控客户端
 */
public class Monitoring {

    //private String host;
    //private int port;
    private volatile boolean exit = false;
    private final EventLoopGroup group = new NioEventLoopGroup();
    private final Bootstrap client = new Bootstrap();

    public static final InetSocketAddress serverAddr = new InetSocketAddress("127.0.0.1", 7777);
    //连接池
    private ChannelPoolMap<InetSocketAddress, SimpleChannelPool> poolMap;
    private FixedChannelPool channelPool;

    /*public ChannelPoolMap<InetSocketAddress, SimpleChannelPool> getPoolMap() {
        return poolMap;
    }*/

    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    public FixedChannelPool getFixedChannelPool() {
        return channelPool;
    }

    public Monitoring() {
    }

    public void run() throws InterruptedException {

        try {
            client.group(group)
                    .channel(NioSocketChannel.class)
//                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .remoteAddress(serverAddr)
                    /*.handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            //加入相关的pipeline
                            pipeline.addLast("decoder", new StringDecoder());  //加入String解码器
                            pipeline.addLast("encoder", new StringEncoder());  //加入String编码器
                            //加入客户端handler
                            pipeline.addLast(new MonitoringHandler());
                        }
                    })*/;
            //连接
//            ChannelFuture channelFuture = client.connect(host, port).sync();
//            channelFuture.addListener((ChannelFutureListener) cf -> {
//                if (channelFuture.isSuccess()) {
//                    System.out.println("当前连接服务器 " + channelFuture.channel().remoteAddress());
//                } else {
//                    System.out.println("客户端启动失败");
//                }
//            });
//            Channel channel = channelFuture.channel();
//            System.out.println("--------" + channel.localAddress() + "--------");

            //初始化连接池
            /*poolMap = new AbstractChannelPoolMap<InetSocketAddress, SimpleChannelPool>() {
                @Override
                protected SimpleChannelPool newPool(InetSocketAddress inetSocketAddress) {
                    return new FixedChannelPool(client, new MonitorChannelPoolHandler(), 8);
                }
            };*/
            channelPool = new FixedChannelPool(client, new MonitorChannelPoolHandler(), 8);

//            while (true) {
//                if (isExit()) {
//                    break;
//                }
//            }

        } catch (Exception e){
            group.shutdownGracefully();
        }
    }

}
