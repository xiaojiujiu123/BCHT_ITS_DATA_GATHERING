package com.bcht.its;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by taosh on 2017/4/27.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Application {
    private static Logger logger = LoggerFactory.getLogger(Application.class);
    public static ConfigurableApplicationContext applicationContext;
    public static void main(String[] args){
        if("start".equals(args[0])){
            start(args);
        }else{
            logger.debug("应用程序关闭中……");
            stop();
        }
    }

    /**
     * 应用程序启动
     * @return
     */
    public static int start(String[] args){
        applicationContext = new SpringApplicationBuilder(Application.class).web(true).run(args);
        return 1;
    }


    public static int stop(){
        return -1;
    }
}


