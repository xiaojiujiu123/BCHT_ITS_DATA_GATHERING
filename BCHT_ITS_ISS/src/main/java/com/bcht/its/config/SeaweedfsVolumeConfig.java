package com.bcht.its.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * seaweedfs的客户端配置
 */
@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "storage.volume")
public class SeaweedfsVolumeConfig {
    /**Volume服务器的IP地址*/
    private String ip;
    /**Volume服务器的端口*/
    private int port;
    /**数据存放目录*/
    private String dir;
    /**每个volume服务器最大能允许多少个volume卷*/
    private int max;
}
