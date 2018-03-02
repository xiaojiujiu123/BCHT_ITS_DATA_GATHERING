package com.bcht.its;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2017/3/28.
 */
@Configuration
public class BeanTools  implements ApplicationContextAware{
    private static ApplicationContext applicationContext;


    public  void setApplicationContext(ApplicationContext context) {
        applicationContext = context;
    }

    public  static Object getBean(Class classname) {
        try{
            Object _restTemplate = applicationContext.getBean(classname);
            return _restTemplate;
        }catch(Exception e){
            return "";
        }
}}
