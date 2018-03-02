package com.bcht.its.storage;

import com.bcht.its.Application;
import com.bcht.its.config.SeaweedfsMasterConfig;
import com.bcht.its.config.SeaweedfsVolumeConfig;
import com.bcht.its.utils.LoadLibUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * Seaweedfs服务启动类
 */
public class Seaweedfs extends Thread  {
    private static Logger logger = LoggerFactory.getLogger(Seaweedfs.class);
    Process process = null;

    @Override
    public void run() {
        try {
            String path = LoadLibUtils.loadExeName("weed.exe");
            logger.info("当前weed.exe完整 路径为:{}",path);
            String cmdStr = "";
            SeaweedfsMasterConfig masterConfig = Application.seaweedfsConfig.getSeaweedfsMasterConfig();
            SeaweedfsVolumeConfig volumeConfig = Application.seaweedfsConfig.getSeaweedfsVolumeConfig();
            if(Application.seaweedfsConfig.isIsmaster()){
                File file = new File(masterConfig.getDir());
                if(!file.exists()){
                    file.mkdirs();
                }
                cmdStr = String.format("%s  master -mdir=%s -volumeSizeLimitMB=%s -ip=%s -ip.bind=%s -port=%s",
                        path,masterConfig.getDir(),masterConfig.getVolumeSizeLimitMB(),masterConfig.getIp(),masterConfig.getIp(),masterConfig.getPort());
            }else{
                File file = new File(volumeConfig.getDir());
                if(!file.exists()){
                    file.mkdirs();
                }
                cmdStr = String.format("%s  volume -ip=%s -ip.bind=%s -port=%s -mserver=%s:%s -dir=%s -max=%s",
                        path,volumeConfig.getIp(),volumeConfig.getIp(),volumeConfig.getPort(),masterConfig.getIp(),masterConfig.getPort(),volumeConfig.getDir(),volumeConfig.getMax());
            }
            process = CMD.CMD(cmdStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
