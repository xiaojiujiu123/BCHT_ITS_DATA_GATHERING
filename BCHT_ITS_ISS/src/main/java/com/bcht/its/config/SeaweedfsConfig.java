package com.bcht.its.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Seaweedfs配置
 */
@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "storage")
public class SeaweedfsConfig {
    /**当前服务器是否为master*/
    private boolean ismaster;
    @Autowired
    private SeaweedfsMasterConfig seaweedfsMasterConfig;
    @Autowired
    private SeaweedfsVolumeConfig seaweedfsVolumeConfig;
}
