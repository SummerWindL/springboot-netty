package com.cluster.springbootnetty.request;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Reace
 * @createTime 20180528 23:43
 * @description 通道初始化类ServerChannelInitializer的编码，主要用于设置各种Handler：
 */

@Component
public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Autowired
    ServerChannelHandler serverChannelHandler;

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        //编码解码
        socketChannel.pipeline().addLast(new HttpRequestDecoder());
        socketChannel.pipeline().addLast(new HttpResponseEncoder());

        socketChannel.pipeline().addLast(serverChannelHandler);//ChannelHandler

    }
}
