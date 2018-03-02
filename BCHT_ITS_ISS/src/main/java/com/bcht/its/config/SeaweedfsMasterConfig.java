package com.bcht.its.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by taosh on 2017/4/26.
 */
@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "storage.master")
public class SeaweedfsMasterConfig {
    /**MasterIP*/
    private String ip;
    /**Master 端口*/
    private int port;
    /**Master目录存放位置*/
    private String dir;
    /**每一个volume大小*/
    private int volumeSizeLimitMB;
}
