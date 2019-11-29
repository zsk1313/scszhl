package org.zhl.scs.service.device.monitor;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.util.StringUtils;

import java.util.concurrent.locks.LockSupport;

/**
 * 监控客户端处理handler类
 */
public class MonitoringHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        System.out.println("读");
        System.out.println(s.trim());
        this.channelReadComplete(channelHandlerContext);
    }

    /**
     * 读写完毕
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channel.close();
    }
}
