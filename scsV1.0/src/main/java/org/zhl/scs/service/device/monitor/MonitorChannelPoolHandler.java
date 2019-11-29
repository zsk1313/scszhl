package org.zhl.scs.service.device.monitor;

import io.netty.channel.Channel;
import io.netty.channel.pool.ChannelPoolHandler;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * channel连接池处理类
 */
public class MonitorChannelPoolHandler implements ChannelPoolHandler {
    /**
     * 回收channel
     * @param channel
     * @throws Exception
     */
    @Override
    public void channelReleased(Channel channel) throws Exception {
        System.out.println("channelReleased. Channel ID: " + channel.id());
    }

    /**
     * 取出channel
     * @param channel
     * @throws Exception
     */
    @Override
    public void channelAcquired(Channel channel) throws Exception {
        System.out.println("channelAcquired. Channel ID: " + channel.id());
    }

    /**
     * 创建channel
     * @param channel
     * @throws Exception
     */
    @Override
    public void channelCreated(Channel channel) throws Exception {
        System.out.println("channelCreated. Channel ID: " + channel.id());
        SocketChannel ch = (SocketChannel) channel;
        ch.config().setTcpNoDelay(true);
        ch.pipeline().addLast(new StringDecoder())
                .addLast(new StringEncoder())
                .addLast("monitoringHandler", new MonitoringHandler());
    }
}
