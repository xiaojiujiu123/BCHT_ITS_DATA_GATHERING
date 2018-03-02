package com.bcht.its;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

/**
 * Created by Administrator on 2017/5/15.
 */
@SpringBootApplication
public class Application4 {
    private static Logger logger = LoggerFactory.getLogger(Application4.class);
    /**
     *
     * @param args
     */
    public static void main(String[] args){
        //start(args);
        if("start".equals(args[0])){
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
        new SpringApplicationBuilder(Application4.class).web(true).run(args);
        return 1;
    }

    /**
     * 启用程序终止
     * @return
     */
    public static int stop(){
        return -1;
    }
}
