package com.cluster.springbootnetty.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Reace
 * @createTime 28 23:29
 * @description 配置文件
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "platform.cluster")
public class ApisProperties {

    private int tokenExpire = 18000;

    private ApiServer server = new ApiServer();


}
