package com.bcht.webservice.rminf.client.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 	交通气象信息写入接口参数类
 * Created by zyq on 2017/4/14.
 */
@XStreamAlias("weather")
public class WeatherRequest {
    private String SBBH;//	设备编号		不可空
    private String JCSD;//	检测时段		不可空	YYYYMMDDHH24
    private String JCZQS;//	检测周期数	不可空
    private String JCSJ;//	检测时间		不可空	格式 YYYY-MM-DD HH24:MI:SS
    private String NJD;//	能见度	    不可空	单位：米
    private String WDU;//	温度	       	单位：摄氏度（℃）
    private String FSDJ;//	风速等级		0-17级
    private String FX;//	风向	    	代码：E-东,S-南,W-西,N-北,SE-东南,SW-西南, NW-西,NE-北东
    private String JYL;//	降雨（积水）量		单位：毫米
    private String JXL;//	降雪（积雪）量		单位：毫米
    private String JCSJLX;//检测事件类型	    有事件时使用以下代码，多个事件时，例“AD”A-大雾,D-降雪（积雪）,E-降雨（积水）,G-大风（横风）,J-温度异常

    public String getSBBH() {
        return SBBH;
    }

    public void setSBBH(String SBBH) throws UnsupportedEncodingException {
        this.SBBH = URLEncoder.encode(SBBH, "UTF-8");
    }

    public String getJCSD() {
        return JCSD;
    }

    public void setJCSD(String JCSD) throws UnsupportedEncodingException {
        this.JCSD = URLEncoder.encode(JCSD, "UTF-8");
    }

    public String getJCZQS() {
        return JCZQS;
    }

    public void setJCZQS(String JCZQS) throws UnsupportedEncodingException {
        this.JCZQS = URLEncoder.encode(JCZQS, "UTF-8");
    }

    public String getJCSJ() {
        return JCSJ;
    }

    public void setJCSJ(String JCSJ) throws UnsupportedEncodingException {
        this.JCSJ = URLEncoder.encode(JCSJ, "UTF-8");
    }

    public String getNJD() {
        return NJD;
    }

    public void setNJD(String NJD) throws UnsupportedEncodingException {
        this.NJD = URLEncoder.encode(NJD, "UTF-8");
    }

    public String getWDU() {
        return WDU;
    }

    public void setWDU(String WDU) throws UnsupportedEncodingException {
        this.WDU = URLEncoder.encode(WDU, "UTF-8");
    }

    public String getFSDJ() {
        return FSDJ;
    }

    public void setFSDJ(String FSDJ) throws UnsupportedEncodingException {
        this.FSDJ = URLEncoder.encode(FSDJ, "UTF-8");
    }

    public String getFX() {
        return FX;
    }

    public void setFX(String FX) throws UnsupportedEncodingException {
        this.FX = URLEncoder.encode(FX, "UTF-8");
    }

    public String getJYL() {
        return JYL;
    }

    public void setJYL(String JYL) throws UnsupportedEncodingException {
        this.JYL = URLEncoder.encode(JYL, "UTF-8");
    }

    public String getJXL() {
        return JXL;
    }

    public void setJXL(String JXL) throws UnsupportedEncodingException {
        this.JXL = URLEncoder.encode(JXL, "UTF-8");
    }

    public String getJCSJLX() {
        return JCSJLX;
    }

    public void setJCSJLX(String JCSJLX) throws UnsupportedEncodingException {
        this.JCSJLX = URLEncoder.encode(JCSJLX, "UTF-8");
    }
}
