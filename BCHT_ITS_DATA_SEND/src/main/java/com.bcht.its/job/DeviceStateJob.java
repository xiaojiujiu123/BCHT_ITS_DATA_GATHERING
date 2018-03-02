package com.bcht.its.job;

import com.bcht.its.dao.DeviceInfoDao;
import com.bcht.its.hession.HessionClient;
import com.bcht.its.its.commons.beans.DeviceInfo;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 查询设备状态的job
 */
@Component
public class DeviceStateJob {
    private Logger logger = Logger.getLogger(DeviceStateJob.class);
    @Autowired
    private DeviceInfoDao deviceInfoDaoImpl;
    @Scheduled(cron = "${device.job.times}")
    public void findDevicesState(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<DeviceInfo> deviceInfoList =deviceInfoDaoImpl.getAllDeviceInfo();
        for(DeviceInfo deviceInfo:deviceInfoList){
            try {
                String resultMsg = HessionClient.uploadDeviceHeartBeat(deviceInfo);
                if(StringUtils.isBlank(resultMsg)){
                    logger.info("设备ip为"+deviceInfo.getIp()+"的设备上传设备心跳成功");
                }else{
                    logger.info("设备ip为"+deviceInfo.getIp()+"的设备上传设备心跳失败");
                }
            }catch (Exception e){
                logger.info("设备ip为"+deviceInfo.getIp()+"的设备上传设备心跳失败");
            }

        }

     }
}
