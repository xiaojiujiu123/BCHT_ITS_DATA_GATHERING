package com.bcht.its.amqp;

import com.bcht.its.MainFrame;
import com.bcht.its.commons.beans.TrafficVechilePassInfo;
import com.bcht.its.hession.HessionClient;
import com.bcht.its.utils.MyPeropertiesUtil;
import com.rabbitmq.client.Channel;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
@RabbitListener(admin = "zwBchtAdmin",bindings =
        {
                @QueueBinding(
                        value = @Queue(value = "ITS_QUEUE_TFCPASS_FAIL",durable = "true",autoDelete = "false",exclusive = "false"),
                        exchange = @Exchange(value = "ITS_EXCHANGE_ITS_TFCPASS",type = ExchangeTypes.TOPIC,durable = "true",autoDelete = "false"),
                        key = "BCHT.TFCPASS.FAIL"

                )
        },
        containerFactory = "zwFactory"
)
public class TfcPassFailDataConsumer {
    protected static Logger logger = LoggerFactory.getLogger(TfcPassFailDataConsumer.class);
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @RabbitHandler
    public void process(Object obj, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag){
        TrafficVechilePassInfo passInfo = null;
        try {
            Message message = (Message)obj;
            if(MainFrame.fxmcMap==null|| MainFrame.hpzlMap==null|| MainFrame.cllxMap==null||
                    MainFrame.clysMap==null|| MainFrame.hpysMap==null|| MainFrame.cdhMap==null){
                //全局缓存未初始化完成之前不消费
                channel.basicReject(tag,true);
                return;
            }
            ByteArrayInputStream bis = new ByteArrayInputStream(message.getBody());
            ObjectInputStream ois = new ObjectInputStream(bis);
            passInfo = (TrafficVechilePassInfo) ois.readObject();
            convertPassInfo(passInfo);
            //获取图片byte数组集合
            List<byte[]> datalist = new ArrayList<byte[]>();
          /*  if(StringUtils.isNotBlank(passInfo.getTpurl())){
                setPicData(datalist,passInfo.getTpurl());
            }
            if(StringUtils.isNotBlank(passInfo.getTpurl1())){
                setPicData(datalist,passInfo.getTpurl1());
            }
            if(StringUtils.isNotBlank(passInfo.getTpurl2())){
                setPicData(datalist,passInfo.getTpurl2());
            }*/
            //把过车图片byte数组设置到过车数据中
            passInfo.setDataList(datalist);
          //  rabbitTemplate.convertAndSend("ITS_EXCHANGE_ITS_TFCPASS","BCHT.TFCPASS",passInfo);
            String resultMsg = HessionClient.uploadPassingVehicle(passInfo);
            if (StringUtils.isNotBlank(resultMsg)) {
                try {
                    channel.basicReject(tag, true);//处理失败,不消费队列中的消息
                    logger.info("分发错误，不消费过车信息");
                } catch (IOException e1) {
                    logger.info("IO异常,无法连接rabbitmq");
                }
            }
        }catch(Exception e) {
            try {
                channel.basicReject(tag, true);//处理失败,不消费队列中的消息
                logger.info("分发错误，不消费过车信息");
                return;
            } catch (IOException e2) {
                logger.info("IO异常,无法连接rabbitmq");
                return;
            }


        }
    }

    /**
     * 根据过车数据获取图片byte数组并添加到数据集合中
     * @param datalist
     * @param fileUrl
     * @throws IOException
     */
    public void setPicData(List<byte[]> datalist,String fileUrl) throws IOException {
        URL url = new URL(fileUrl);
        byte[] source = IOUtils.toByteArray(url.openStream());
        datalist.add(source);
    }

    /**
     * 转换成对应平台的过车数据
     * @param passInfo
     */
    public void convertPassInfo( TrafficVechilePassInfo passInfo){
        String cllx = passInfo.getCllx();
        String hpzl = passInfo.getHpzl();
        String hpys = passInfo.getHpys();
        String clys = passInfo.getClys();
        String cdh = passInfo.getCdbh()+"";
        String sbxh = passInfo.getSbxh();
        //从缓存变量中获取对应平台代码
        if(passInfo.getCsbh().equals("01")){
            cllx = MainFrame.cllxMap.get(cllx);
            hpzl = MainFrame.hpzlMap.get(hpzl);
            hpys = MainFrame.hpysMap.get(hpys);
            clys = MainFrame.clysMap.get(clys);

        }
        cdh = MainFrame.cdhMap.get(cdh);
        String fxmc = MainFrame.fxmcMap.get(sbxh);
        //没有获取到对应平台的代码设置默认值
        if(StringUtils.isBlank(cllx)){
            cllx = MyPeropertiesUtil.getValue("CLLX_DEFAULT");
        }
        if(StringUtils.isBlank(hpzl)){
            hpzl = MyPeropertiesUtil.getValue("HPZL_DEFAULT");
        }
        if(StringUtils.isBlank(hpys)){
            hpys = MyPeropertiesUtil.getValue("HPYS_DEFAULT");
        }
        if(StringUtils.isBlank(clys)){
            clys = MyPeropertiesUtil.getValue("CLYS_DEFAULT");
        }
        if(StringUtils.isBlank(cdh)){
            cdh = MyPeropertiesUtil.getValue("CDH_DEFAULT");
        }
        passInfo.setCllx(cllx);
        passInfo.setHpzl(hpzl);
        passInfo.setHpys(hpys);
        passInfo.setClys(clys);
        passInfo.setCdbh(Integer.parseInt(cdh));
        passInfo.setFxmc(fxmc);
    }
}
