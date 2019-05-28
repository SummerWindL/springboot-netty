package com.cluster.springbootnetty;

import io.netty.channel.ChannelFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.cluster")
public class SpringbootNettyApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootNettyApplication.class, args);
    }

    @Autowired
    private NettyServer nettyServer;

    @Override
    public void run(String... args) throws Exception {
        ChannelFuture start = nettyServer.start();
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                nettyServer.destroy();
            }
        });
        start.channel().closeFuture().syncUninterruptibly();

    }


}
