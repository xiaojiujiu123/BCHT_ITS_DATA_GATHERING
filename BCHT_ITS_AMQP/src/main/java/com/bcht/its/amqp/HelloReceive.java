package com.bcht.its.amqp;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by taosh on 2017/4/27.
 */
@Component
@RabbitListener(admin = "BchtAdmin",bindings =
        {
                @QueueBinding(
                        value = @Queue(value = "BCHT_ITS_TEST",durable = "true",autoDelete = "false",exclusive = "false"),
                        exchange = @Exchange(value = "ITS_EXCHANGE_ITS_TFCPASS",type = ExchangeTypes.TOPIC,durable = "true",autoDelete = "false"),
                        key = "BCHT.DEV.#"

                )
        }

)
public class HelloReceive   {
    @RabbitHandler
    public void processC(Object message, Channel channel,@Header(AmqpHeaders.DELIVERY_TAG) long tag)  {
        if(message instanceof Message){
            Message msg = (Message)message;
            try {
                String msgContent = new String(msg.getBody(),"UTF-8");
                System.out.println("Receive:"+new String(msg.getBody(),"UTF-8"));
                if("1".equals(msgContent)){
                    channel.basicAck(msg.getMessageProperties().getDeliveryTag(), false); //确认消息成功消费
                }else{
                    channel.basicReject(tag, true);
                   //channel.basicNack(msg.getMessageProperties().getDeliveryTag(), true,true); //确认消息成功消费
                }
            } catch (IOException e) {
                try {
                    channel.basicReject(tag, true);
                    //channel.basicNack(msg.getMessageProperties().getDeliveryTag(), true,true); //确认消息成功消费
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
