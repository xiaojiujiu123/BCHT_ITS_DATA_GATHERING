package com.bcht.its.storage;

import com.bcht.its.Application;
import com.bcht.its.config.SeaweedfsMasterConfig;
import com.bcht.its.config.SeaweedfsVolumeConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * Created by yx on 2017-04-27.
 */
public class StopSeaweedfs {
    private static Logger logger = LoggerFactory.getLogger(StopSeaweedfs.class);
    public static String getPid(int port) {
        String pid = null;
        String str = null;
        try {
            Process process = Runtime.getRuntime().exec("cmd.exe /c netstat -aon|findstr \""+port+"\"");
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(), Charset.forName("GBK")));
            str = br.readLine();
            logger.info(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!str.isEmpty()) {
            String str1 = str.substring(str.indexOf("LISTENING") + 9).trim();
            if (str1.trim().indexOf(" ") != -1) {
                pid = str1.substring(0, str1.trim().indexOf(" ")).trim();
            } else {
                pid = str1;
            }
        }else {
            return null;
        }
        return pid;
    }

    public void stop(){
        int port = 0;
        SeaweedfsMasterConfig masterConfig = Application.seaweedfsConfig.getSeaweedfsMasterConfig();
        SeaweedfsVolumeConfig volumeConfig = Application.seaweedfsConfig.getSeaweedfsVolumeConfig();
        if(Application.seaweedfsConfig.isIsmaster()){
            port = masterConfig.getPort();
        }else {
            port = volumeConfig.getPort();
        }
        String pid = StopSeaweedfs.getPid(port);
        CMD.CMD("cmd.exe /c taskkill /PID " + pid + " /F /T ");
    }
}
