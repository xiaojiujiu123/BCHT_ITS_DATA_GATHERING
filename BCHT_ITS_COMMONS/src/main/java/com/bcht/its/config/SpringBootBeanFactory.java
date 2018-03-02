package com.bcht.its.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by taosh on 2017/4/18.
 */
@Component
public class SpringBootBeanFactory implements ApplicationContextAware {
    private static ApplicationContext applicationContext = null;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(SpringBootBeanFactory.applicationContext == null){
            SpringBootBeanFactory.applicationContext = applicationContext;
        }
    }

    public <X> X getBean(Class<X> clzz){
        return applicationContext.getBean(clzz);
    }
}
