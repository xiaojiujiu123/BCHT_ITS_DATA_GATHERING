package com.bcht;


import com.bcht.entity.*;
import com.bcht.rabbitMQ.XstreamUtils;
import com.bcht.webserviceclient.Client;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.authserver.OAuth2AuthorizationServerConfiguration;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;

import static javafx.scene.input.KeyCode.T;

/**
 * Created by Administrator on 2017/5/15.
 */
@SpringBootApplication
public class Application1 {
    private static Logger logger = LoggerFactory.getLogger(Application1.class);
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
        new SpringApplication(Application1.class).run(args);
        test();
        return 1;
    }

    /**
     * 启用程序终止
     * @return
     */
    public static int stop(){
        return -1;
    }

    public static void test(){
        /*Surexamine surexamineRequest = new Surexamine();
        surexamineRequest.setSbbh("520382000000010051");
        surexamineRequest.setZqmj("");
        surexamineRequest.setClfl("3");
        surexamineRequest.setHphm("贵A12345");
        surexamineRequest.setHpzl("01");
        surexamineRequest.setFzjg("");
        surexamineRequest.setJdcsyr("");
        surexamineRequest.setCsys("A");
        surexamineRequest.setClpp("");
        surexamineRequest.setJtfs("");
        surexamineRequest.setZsxzqh("");
        surexamineRequest.setDh("");
        surexamineRequest.setLxfs("");
        surexamineRequest.setXcfw("0");
        surexamineRequest.setXzqh("533603");

        surexamineRequest.setWfdd("");
        surexamineRequest.setLddm("");
        surexamineRequest.setDdms("");
        surexamineRequest.setWfdz("");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //String wfsj = sdf.format("2019-09-12 00:00:00");
        surexamineRequest.setWfsj("2016-09-12 00:00:00");
        surexamineRequest.setWfsj1("");
        surexamineRequest.setWfxw("1304");
        surexamineRequest.setScz("");
        surexamineRequest.setBzz("");
        surexamineRequest.setZpsl("1");
        surexamineRequest.setZpstr1("http://10.162.89.77:8081/997,174ca029935d68");
        surexamineRequest.setZpstr2("");
        surexamineRequest.setZpstr3("");*/
       /* Qstation qstationRequest = new Qstation();
        qstationRequest.setGlbmt("533603000010");*/

        /*try {
           String str = Client.writerxml(qstationRequest);
            System.out.println(str);
        } catch (RemoteException e) {
            e.printStackTrace();
        }*/

        /*QueryCondition qvehBus = new QueryCondition();
        qvehBus.setHphm("CMC485");
        qvehBus.setHpzl("02");
        */
        /*try {
            String str = Client.queryxml(qstationRequest);

            Object obj = XstreamUtils.xmlToObject(str,Root1.class);
            String jsonStr = JSONObject.fromObject(obj).toString();
                    System.out.println(jsonStr);
        } catch (RemoteException e) {
            e.printStackTrace();
        }*/
    }
}
