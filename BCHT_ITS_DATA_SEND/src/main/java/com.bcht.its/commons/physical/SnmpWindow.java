package com.bcht.its.commons.physical;


import com.bcht.its.commons.snmp.SystemInfo;

/**
 * 主要针对ESXI的snmp采集
 * Created by Administrator on 14-5-26.
 */
public class SnmpWindow extends SnmpBase {
    public SnmpWindow(String ip, String community) {
        super(ip, community);
    }

    public SystemInfo getSysInfo() throws Exception {
        SystemInfo sysInfo = super.getSysInfo();

        sysInfo.setMemoryInfo(getMemoryInfo());
        sysInfo.setDiskInfos(getDiskInfo());
        sysInfo.setCpuInfo(getCpuInfo());
        return sysInfo;
    }

    public static void main(String[] args){
        SnmpWindow windows = new SnmpWindow("192.168.3.102","public");
        try {
            SystemInfo sysinfo =  windows.getSysInfo();
            System.out.println(sysinfo.getCpuInfo());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}