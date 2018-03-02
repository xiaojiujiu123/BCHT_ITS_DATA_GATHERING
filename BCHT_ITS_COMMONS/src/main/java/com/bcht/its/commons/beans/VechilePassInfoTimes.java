package com.bcht.its.commons.beans;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 过车信息中关键时间点
 */
@Getter
@Setter
public class VechilePassInfoTimes implements Serializable{
    private static final long serialVersionUID = 1L;
    /**车辆经过时间 从SDK协议中获取*/
    private Date jgsj;
    /**接收服务接收到数据的时间*/
    private Date acceptTime;
    /**解析服务解析成功之后的时间*/
    private Date analysisTime;
    /**发送到消息队列中的时间*/
    private Date sendToMQTime;
    /**从消息队列中取出的时间*/
    private Date getForMQTime;
    /**数据入库时间*/
    private Date storageTime;
    /**发送到蓝盾平台的时间*/
    private Date sendToLDTime;
    /**发送到集成指挥平台的时间*/
    private Date sendToRminfTime;
    /**发送到六合一的时间*/
    private Date sendToTmriTime;
}
