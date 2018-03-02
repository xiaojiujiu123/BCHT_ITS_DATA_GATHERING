package com.bcht.its;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;


/**
 * 应用程序启动主入口
 */
@EnableDiscoveryClient
@SpringBootApplication
public class Application {
    /**
     * 分发程序入口
     * @param args
     */



    public static void main(String[] args) throws Exception{
        if("start".equals(args[0])){
            start(args);
        }else{
            stop();
        }
    }

    public static int start(String[] args) throws Exception{
        ApplicationContext context=new SpringApplicationBuilder(Application.class).web(true).run(args);
        MainFrame mainFrame = context.getBean(MainFrame.class);
        mainFrame.start(context);
        return 1;
    }



    public static int stop(){
        return -1;
    }
}
