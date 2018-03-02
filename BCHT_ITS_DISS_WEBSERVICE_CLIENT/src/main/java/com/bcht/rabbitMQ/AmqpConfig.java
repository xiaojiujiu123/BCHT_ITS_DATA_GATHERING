/*
package com.bcht.rabbitMQ;

import com.bcht.entity.*;
import com.bcht.webserviceclient.Client;
import com.rabbitmq.client.Channel;
import net.sf.json.JSONObject;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.SimpleAmqpHeaderMapper;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.io.IOException;

*/
/**
 * Created by Administrator on 2017/5/16.
 *//*

//@ConfigurationProperties(prefix = "spring.rabbitmq")
@Configuration
public class AmqpConfig {
    public static final String EXCHANGE = "survey_center";
    public static final String ROUTINGKEY = "ice_violation_vehicle";
    private String host = PropertiesUtils.getValue("spring.rabbitmq.host");
    private int port = Integer.parseInt(PropertiesUtils.getValue("spring.rabbitmq.port"));
    private String username = PropertiesUtils.getValue("spring.rabbitmq.username");
    private String password = PropertiesUtils.getValue("spring.rabbitmq.password");
    private String virtualhost = PropertiesUtils.getValue("spring.rabbitmq.virtualhost");

    @Bean
    public ConnectionFactory connectionFactory(){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses(host);
        connectionFactory.setPort(port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        //connectionFactory.setVirtualHost(virtualhost);
        connectionFactory.setPublisherConfirms(true); //必须要设置
        return connectionFactory;
    }
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RabbitTemplate rabbitTemplate(){
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        return template;
    }
    */
/**
     * 针对消费者配置:1.设置交换机,2.将队列绑定到交换机
     *//*

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public Queue queue(){
        return new Queue("passing_ceshi",true);//队列持久
    }

    @Bean
    public Binding binding(){
        return BindingBuilder.bind(queue()).to(directExchange()).with(AmqpConfig.ROUTINGKEY);
    }
    @Bean
    public SimpleMessageListenerContainer messageContainer(){
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory());
        container.setQueues(queue());
        container.setExposeListenerChannel(true);
        container.setMaxConcurrentConsumers(1);
        container.setConcurrentConsumers(1);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);//设置确认模式手工确认
        container.setMessageListener(new ChannelAwareMessageListener() {
            @Override
            public void onMessage(Message message, Channel channel) throws IOException {
                byte[] body = message.getBody();
                String json = new String(body);






                */
/*Feedback feedback = new Feedback();
                feedback.setYjxh("1200340056007800");
                feedback.setYwlx("1");
                feedback.setQsjg("1");
                feedback.setSfcjlj("0");
                feedback.setCzdw("521300265544");
                feedback.setCzr("yyy");
                feedback.setCzsj("2017-05-15 16:56:30");
                Client.writerxml(feedback);*//*


                */
/*Incident incident = new Incident();
                incident.setSBLY("1");
                incident.setSBBH("");*//*




                */
/*Feedbackpic feedbackpic = new Feedbackpic();
                feedbackpic.setYjxh("2017050915170729");
                feedbackpic.setTp1("http://10.166.193.102/PassImage.aspx?devicenbr=533601000010020004&snapnbr=20170509151707299&server=10.166.193.102&index=0");
                feedbackpic.setScdw("521300265544");
                feedbackpic.setScr("nnn");
                Client.writerxml(feedbackpic);*//*

                */
/*Surexamine surexamine = new Surexamine();
                surexamine.setSbbh("533601000010030026");
                surexamine.setClfl("3");
                surexamine.setHphm("云M12365");
                surexamine.setHpzl("01");
                surexamine.setWfsj("2014-09-13 15:24:30");
                surexamine.setWfxw("1349B");
                surexamine.setZpsl("1");
                surexamine.setZpstr1("http://10.166.193.102/PassImage.aspx?devicenbr=533601000010020004&snapnbr=20170509151707299&server=10.166.193.102&index=0");
                Client.writerxml(surexamine);*//*

                */
/*QstationRelation qstationRelation = new QstationRelation();
                qstationRelation.setFwzbh("533601000010040000");
                Client.writerxml(qstationRelation);*//*


                System.out.println("receive msg:"+new String(body));
                channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);//确认消息成功消费
            }
        });
        return container;
    }
}
*/
