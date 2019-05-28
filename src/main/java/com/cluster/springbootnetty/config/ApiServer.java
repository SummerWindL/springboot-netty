package com.cluster.springbootnetty.config;

import lombok.Data;

/**
 * @author Reace
 * @createTime 2018528 23:32
 * @description 服务器配置
 */
@Data
public class ApiServer {

    private String ip = "127.0.0.1";

    //端口
    private int port = 16080;

    //线程数
    private int threadCount = 8;
}
