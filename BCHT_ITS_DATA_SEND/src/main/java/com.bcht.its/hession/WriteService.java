package com.bcht.its.hession;

/**
 * Created by Administrator on 2017/5/23.
 */
public interface WriteService {
    /**
     * 写入过车数据
     * @param key 许可
     * @param passingVehicle 过车数据(json格式)
     * @return
     */
    String WritePassVehicle(String key,String passingVehicle);

    /**
     * 写入违法数据
     * @param key 许可
     * @param violationVehicle 违法过车数据(json格式)
     * @return
     */
    String WriteViolationVehicle(String key,String violationVehicle);

    /**
     * 写入设备心跳
     * @param key
     * @param hearbeat
     * @return
     */
    String WriteDeviceHeatBeat(String key,String hearbeat);

    /**
     * 写入设备心跳
     * @param key
     * @param hearbeat
     * @return
     */
    String WriteServiceHeatBeat(String key,String hearbeat);
}
