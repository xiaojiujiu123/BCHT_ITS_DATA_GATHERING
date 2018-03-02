package com.bcht.its;

import com.bcht.its.config.SeaweedfsConfig;
import com.bcht.its.storage.Seaweedfs;
import com.bcht.its.storage.StopSeaweedfs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;



/**
 * 应用程序启动主入口
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Application {
    private static Logger logger = LoggerFactory.getLogger(Application.class);
    public static ConfigurableApplicationContext applicationContext;

    /**服务器配置*/
    public static SeaweedfsConfig seaweedfsConfig;
    public static void main(String[] args){
        if("start".equals(args[0])) {
            logger.info("应用程序启动中……");
            start(args);
        }else{
            logger.info("应用程序停止……");
            stop();
        }
    }

    /**
     * 应用程序启动
     * @return
     */
    public static int start(String[] args){
        applicationContext = new SpringApplicationBuilder(Application.class).web(true).run(args);
        seaweedfsConfig = applicationContext.getBean(SeaweedfsConfig.class);
        new Seaweedfs().start();
        return 1;
    }

    public static int stop(){
        new StopSeaweedfs().stop();
        System.exit(0);
        return -1;
    }


}
