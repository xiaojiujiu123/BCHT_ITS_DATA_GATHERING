package com.bcht.its.service;

/**
 * Created by Administrator on 2017/5/18.
 */
public interface BchtTrffService {
    /**
     * 百诚慧通过车写入接口
     * @param key 序列号
     * @param passingVehicle 过车对象JSO
     * @return
     */
    public String writePassVehicle(String key, String passingVehicle);
    /**
     * 百诚慧通过车违法写入接口
     * @param key 序列号
     * @param violationVehicle 过车违法对象JSON
     * @return
     */
    public String writeViolationVehicle(String key, String violationVehicle);
    /**
     * 百诚慧通
     * @param key 序列号
     * @param heartBeat 设备心跳对象JSON
     * @return
     */
    public String writeHeartBeat(String key, String heartBeat);


    /**
     * 写入服务器心跳
     * @param key
     * @param hearbeat
     * @return
     */
    String WriteServiceHeatBeat(String key, String hearbeat);
}
