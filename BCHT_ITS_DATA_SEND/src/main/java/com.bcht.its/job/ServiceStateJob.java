package com.bcht.its.job;

import com.bcht.its.commons.physical.SnmpWindow;
import com.bcht.its.commons.snmp.CpuInfo;
import com.bcht.its.commons.snmp.DiskInfo;
import com.bcht.its.commons.snmp.MemoryInfo;
import com.bcht.its.commons.snmp.SystemInfo;
import com.bcht.its.hession.HessionClient;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 相机接入服务器状态job
 */
@Component
public class ServiceStateJob {
    private Logger logger = Logger.getLogger(ServiceStateJob.class);
    @Value("${service.ds.job.ip}")
    private String serviceDsIp;//接入服务ip
    @Value("${service.pic.job.ip}")
    private String servciePicIp;//图片存储ip
    @Value("${community}")
    private String community = "public";
    @Value("${ds_service_id}")
    private String dsServiceId;
    @Value("${pic_service_id}")
    private String picServiceId;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Scheduled(cron = "${service.job.times}")
    public void start(){
        try {
            //获取接入服务器snmp采集
            SnmpWindow dsServiceWindows = new SnmpWindow(serviceDsIp,community);
            SystemInfo systemInfo = dsServiceWindows.getSysInfo();
            String resultMsg = HessionClient.uploadServiceHeartbeat(systemInfo,dsServiceId,serviceDsIp);
            if(StringUtils.isNotBlank(resultMsg)){
                logger.info("服务编号为"+dsServiceId+"的服务上传服务心跳失败");
            }
        }catch (Exception e) {
            logger.info("服务编号为"+dsServiceId+"的设备上传设备心跳失败");
        }
        try {
            //获取图片服务器snmp采集
            SnmpWindow picServiceWindows = new SnmpWindow(servciePicIp,community);
            SystemInfo picSystemInfo = picServiceWindows.getSysInfo();
            String resultMsg = HessionClient.uploadServiceHeartbeat(picSystemInfo,picServiceId,servciePicIp);
            if(StringUtils.isNotBlank(resultMsg)){
                logger.info("服务编号为"+dsServiceId+"的服务上传服务心跳失败");
            }
        }catch (Exception e) {
            logger.info("服务编号为"+dsServiceId+"的服务上传服务心跳失败");
        }

    }
    public static void main(String[] args) throws Exception {
        SnmpWindow dsServiceWindows = new SnmpWindow("10.20.11.207","public");
        SystemInfo systemInfo = dsServiceWindows.getSysInfo();
    }
}
