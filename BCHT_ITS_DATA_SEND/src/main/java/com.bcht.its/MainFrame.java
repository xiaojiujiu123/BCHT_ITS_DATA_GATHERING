package com.bcht.its;

import com.bcht.its.utils.MyPeropertiesUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/16.
 */
@Component
public class MainFrame {
    public static String SEND_PLATFORM = MyPeropertiesUtil.getValue("SEND_PLATFORM");
    //平台对应的参数类型
    public static String CSLX_FXMC = MyPeropertiesUtil.getValue("CSLX_FXMC");//方向名称
    public static String CSLX_HPZL = MyPeropertiesUtil.getValue("CSLX_HPZL");//号牌种类
    public static String CSLX_HPYS = MyPeropertiesUtil.getValue("CSLX_HPYS");//号牌颜色
    public static String CSLX_CLLX = MyPeropertiesUtil.getValue("CSLX_CLLX");//车辆类型
    public static String CSLX_CLYS = MyPeropertiesUtil.getValue("CSLX_CLYS");//车辆颜色
    public static String CSLX_CDH = MyPeropertiesUtil.getValue("CSLX_CDH");//车道号
    public static String GCTY_LOCAL_LX = MyPeropertiesUtil.getValue("GCTY_LOCAL_LX");//本地通用过车数据类型
    public static String DEVICE_LOCAL_LX = MyPeropertiesUtil.getValue("DEVICE_LOCAL_LX");//本地设置数据类型

    //全局缓存变量
    public static Map<String, String> fxmcMap = null;//方向类型本地参数
    public static Map<String, String> hpzlMap = null;//号牌种类参数
    public static Map<String, String> cllxMap = null;//车辆类型本地参数
    public static Map<String, String> clysMap = null;//车辆颜色本地参数
    public static Map<String, String> hpysMap = null;//号牌颜色本地参数
    public static Map<String, String> cdhMap = null;//车道号本地参数
    /**海康厂商在系统中所对应的厂商编号**/
    public static String HK_FACTORY=MyPeropertiesUtil.getValue("HK_FACTORY");

    public void start(ApplicationContext context) {
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        String fxmcSql = " select bdbh,csz from sys_magic where sjdm='" + DEVICE_LOCAL_LX + "' and ptdm='" + SEND_PLATFORM + "' and cslx='" + CSLX_FXMC + "'";
        String hpzlSql = " select bdbh,csz from sys_magic where sjdm='" + GCTY_LOCAL_LX + "' and ptdm='" + SEND_PLATFORM + "' and cslx='" + CSLX_HPZL + "'";
        String hpysSql = " select bdbh,csz from sys_magic where sjdm='" + GCTY_LOCAL_LX + "' and ptdm='" + SEND_PLATFORM + "' and cslx='" + CSLX_HPYS + "'";
        String cllxSql = " select bdbh,csz from sys_magic where sjdm='" + GCTY_LOCAL_LX + "' and ptdm='" + SEND_PLATFORM + "' and cslx='" + CSLX_CLLX + "'";
        String clysSql = " select bdbh,csz from sys_magic where sjdm='" + GCTY_LOCAL_LX + "' and ptdm='" + SEND_PLATFORM + "' and cslx='" + CSLX_CLYS + "'";
        String cdhSql = " select bdbh,csz from sys_magic where sjdm='" + GCTY_LOCAL_LX + "' and ptdm='" + SEND_PLATFORM + "' and cslx='" + CSLX_CDH + "'";
        //初始化本地参数
        fxmcMap = init(jdbcTemplate, fxmcSql);
        hpzlMap = init(jdbcTemplate, hpzlSql);
        cllxMap = init(jdbcTemplate, cllxSql);
        clysMap = init(jdbcTemplate, clysSql);
        hpysMap = init(jdbcTemplate, hpysSql);
        cdhMap = init(jdbcTemplate, cdhSql);
    }


    /**
     * 初始化本地参数
     *
     * @param jdbcTemplate
     * @param sql
     * @return
     */
    public static Map init(JdbcTemplate jdbcTemplate, String sql) {
        List<Map<String, Object>> listMap = jdbcTemplate.queryForList(sql);
        Map<String, String> dataMap = new HashMap<String, String>();
        for (Map<String, Object> map : listMap) {
            dataMap.put((String) map.get("bdbh"), (String) map.get("csz"));
        }
        return dataMap;

    }
}