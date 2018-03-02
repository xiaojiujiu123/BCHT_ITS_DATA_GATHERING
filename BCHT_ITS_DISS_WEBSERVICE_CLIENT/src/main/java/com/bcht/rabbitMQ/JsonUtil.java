package com.bcht.rabbitMQ;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;

import net.sf.json.JSONObject;

/**
 * MQ数据转json
 * @author zyq
 *
 */
public class JsonUtil {
	private static Logger logger = LoggerFactory.getLogger(JsonUtil.class);
	public static JSONObject changeJson(Message message) throws IOException{
		ByteArrayInputStream byteInt=new ByteArrayInputStream(message.getBody());
	    logger.info("过车数据对象组装！");
	    InputStreamReader objInt =new InputStreamReader(byteInt,"UTF-8");
	    BufferedReader reader = new BufferedReader(objInt);
	    String string=null;
	    StringBuffer sb = new StringBuffer();
	    while((string = reader.readLine())!=null){
	        sb.append(string);
	    }
	    JSONObject json =JSONObject.fromObject(sb.toString());
	    logger.info("JSON输出： "+json);
		return json;
	}
	
}
