package com.bcht.its.hession;

import com.bcht.its.commons.snmp.CpuInfo;
import com.bcht.its.commons.snmp.DiskInfo;
import com.bcht.its.commons.snmp.MemoryInfo;
import com.bcht.its.commons.snmp.SystemInfo;
import com.bcht.its.its.commons.beans.DeviceInfo;
import com.bcht.its.its.commons.beans.TrafficVechilePassInfo;
import com.bcht.its.service.BchtTrffService;
import com.bcht.its.utils.MyPeropertiesUtil;
import com.caucho.hessian.client.HessianProxyFactory;
import net.sf.json.JSONObject;

import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * hession接口工具类
 */
public class HessionClient {
    private static String hessionUrl = MyPeropertiesUtil.getValue("hession.url");
    private static String key = MyPeropertiesUtil.getValue("hession.key");
    private static BchtTrffService writeService = null;
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static void init() throws MalformedURLException {
        HessianProxyFactory proxyFactory =  new HessianProxyFactory();
        writeService = (BchtTrffService)proxyFactory.create(BchtTrffService.class,hessionUrl);
    }

    /**
     * 上传普通过车数据
     * @param passingVehicle
     * @return
     * @throws MalformedURLException
     */
    public static String uploadPassingVehicle(TrafficVechilePassInfo passingVehicle) throws MalformedURLException {
        if(passingVehicle==null){
            return "过车数据未组装完成!";
        }
        if(writeService==null){
            init();
        }
        JSONObject json = convertToJSONObject(passingVehicle);
        return writeService.writePassVehicle(key,json.toString());
    }

    /**
     *
     * @param systemInfo
     * @return
     */
    public static String uploadServiceHeartbeat(SystemInfo systemInfo, String serviceId,String serviceDsIp) throws MalformedURLException {
        if(writeService==null){
            init();
        }
        JSONObject jsonObject = convertServiceHeatbeat(systemInfo,serviceId,serviceDsIp);
        return writeService.WriteServiceHeatBeat(key,jsonObject.toString());
    }

    /**
     * 组装服务心跳json
     * @param systemInfo
     * @param serviceId
     * @param serviceDsIp
     * @return
     */
    public static JSONObject convertServiceHeatbeat(SystemInfo systemInfo,String serviceId,String serviceDsIp){
        CpuInfo cpuInfo = systemInfo.getCpuInfo();
        MemoryInfo memoryInfo = systemInfo.getMemoryInfo();
        List<DiskInfo> diskInfoList = systemInfo.getDiskInfos();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("fwbh",serviceId);
        jsonObject.put("fwip",serviceDsIp);
        jsonObject.put("fwzt",0);
        jsonObject.put("gzms","");
        jsonObject.put("cpusyl",cpuInfo.getSysRate());
        jsonObject.put("nczl",memoryInfo.getMemorySize());
        jsonObject.put("ncsyl",memoryInfo.getMemoryUsedSize());
        jsonObject.put("nckxl",memoryInfo.getMemoryFreeSize());
        String cpzkj = diskInfoList.get(0).getDiskSize();
        String cpsykj = diskInfoList.get(0).getDiskUsedSize();
        String cpkxkj = diskInfoList.get(0).getDiskFreeSize();
        for(int i=1;i<diskInfoList.size()-1;i++){
            cpzkj = cpzkj+","+diskInfoList.get(i).getDiskSize();
            cpsykj = cpsykj+","+diskInfoList.get(i).getDiskUsedSize();
            cpkxkj = cpkxkj+","+diskInfoList.get(i).getDiskFreeSize();
        }
        jsonObject.put("cpzkj",cpzkj);
        jsonObject.put("cpsykj",cpsykj);
        jsonObject.put("cpkxkj",cpkxkj);
        jsonObject.put("qdsj","");
        jsonObject.put("dqsj",sdf.format(new Date()));
        return  jsonObject;
    }

    /**
     * 上传违法数据
     * @param violationVehicle
     * @return
     */
    public static String uploadViolationVehicle(TrafficVechilePassInfo violationVehicle) throws MalformedURLException {
        if(violationVehicle==null){
            return "违法过车数据未组装完成!";
        }
        if(writeService==null){
            init();
        }
        JSONObject json = convertToJSONObject(violationVehicle);
        return writeService.writeViolationVehicle(key,json.toString());
    }

    /**
     *
     * @param deviceInfo
     * @return
     * @throws MalformedURLException
     */
    public static String uploadDeviceHeartBeat(DeviceInfo deviceInfo) throws MalformedURLException {
        if(writeService==null){
            init();
        }
        JSONObject jsonObject = convertDeviceInfo(deviceInfo);
       return writeService.writeHeartBeat(key,jsonObject.toString());
    }

    /**
     * 把设备数据装成Hession指定格式
     * @param deviceInfo
     * @return
     */
    public static JSONObject convertDeviceInfo(DeviceInfo deviceInfo){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sbbh",deviceInfo.getSbbh());
        jsonObject.put("sbip",deviceInfo.getIp());
        String zt = deviceInfo.getZt();
        String gzmc = "";
        if("01".equals(zt)){
            zt="0";
            gzmc = "正常";
        }else if("01".equals(zt)){
            zt="4";
            gzmc = "离线";
        }else if("02".equals(zt)){
            zt="5";
            gzmc = "用户密码错误";
        }
        jsonObject.put("sbzt",zt);
        jsonObject.put("gzms",deviceInfo.getSbmc()+"设备"+gzmc);
        jsonObject.put("jd",deviceInfo.getJd());
        jsonObject.put("wd",deviceInfo.getWd());
        jsonObject.put("sbqdsj",sdf.format(deviceInfo.getLastLoginTime()));
        jsonObject.put("sbdqsj",sdf.format(new Date()));
        return jsonObject;
    }

    /**
     * 根据过车数据转乘HESSION接口标准的json数据
     * @param passingVehicle
     * @return
     */
    public static JSONObject convertToJSONObject(TrafficVechilePassInfo passingVehicle){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("lsh",passingVehicle.getGcbh());
        jsonObject.put("sbbh",passingVehicle.getSbxh());
        jsonObject.put("cwkc",(int)passingVehicle.getCwkc()+"");
        jsonObject.put("gcsj",sdf.format(passingVehicle.getVechilePassInfoTimes().getJgsj()));
        jsonObject.put("csys",passingVehicle.getClys());
        jsonObject.put("cdbh",passingVehicle.getCdbh()+"");
        jsonObject.put("hpzl",passingVehicle.getHpzl());
        jsonObject.put("hphm",passingVehicle.getHphm());
        jsonObject.put("wfdm",passingVehicle.getWfdm());
        jsonObject.put("fxlx",passingVehicle.getFx());
        jsonObject.put("fx",passingVehicle.getFxmc()==null?"":passingVehicle.getFxmc());
        jsonObject.put("hpys",passingVehicle.getHpys());
        jsonObject.put("clsd",passingVehicle.getSd());
        jsonObject.put("cllx",passingVehicle.getCllx());
        jsonObject.put("tpurl",passingVehicle.getTpurl());
        jsonObject.put("tpurl1",passingVehicle.getTpurl1()==null?"":passingVehicle.getTpurl1());
        jsonObject.put("tpurl2",passingVehicle.getTpurl2()==null?"":passingVehicle.getTpurl2());
        return jsonObject;
    }

}
