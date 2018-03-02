package com.bcht.webservice.rminf.client.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 单警定位信息接入接口参数类
 * Created by zyq on 2017/4/14.
 */
@XStreamAlias("police")
public class PoliceRequest {
    private String GPSBH;//GPS设备编号
    private String RYLX;//人员类型      1-警员；2-协勤
    private String RYBH;//人员编号
    private String SBSJ;//上报时间      不可空    格式：YYYY-MM-DD- HH24:MI:SS
    private String JD;//经度          不可空
    private String WD;//维度          不可空
    private String SD;//速度          3位整，可带1位小数
    private String FX;//方向          角度 1-360

    public String getGPSBH() {
        return GPSBH;
    }

    public void setGPSBH(String GPSBH) throws UnsupportedEncodingException {
        this.GPSBH = URLEncoder.encode(GPSBH, "UTF-8");
    }

    public String getRYLX() {
        return RYLX;
    }

    public void setRYLX(String RYLX) throws UnsupportedEncodingException {
        this.RYLX = URLEncoder.encode(RYLX, "UTF-8");
    }

    public String getRYBH() {
        return RYBH;
    }

    public void setRYBH(String RYBH) throws UnsupportedEncodingException {
        this.RYBH = URLEncoder.encode(RYBH, "UTF-8");
    }

    public String getSBSJ() {
        return SBSJ;
    }

    public void setSBSJ(String SBSJ) throws UnsupportedEncodingException {
        this.SBSJ = URLEncoder.encode(SBSJ, "UTF-8");
    }

    public String getJD() {
        return JD;
    }

    public void setJD(String JD) throws UnsupportedEncodingException {
        this.JD = URLEncoder.encode(JD, "UTF-8");
    }

    public String getWD() {
        return WD;
    }

    public void setWD(String WD) throws UnsupportedEncodingException {
        this.WD = URLEncoder.encode(WD, "UTF-8");
    }

    public String getSD() {
        return SD;
    }

    public void setSD(String SD) throws UnsupportedEncodingException {
        this.SD = URLEncoder.encode(SD, "UTF-8");
    }

    public String getFX() {
        return FX;
    }

    public void setFX(String FX) throws UnsupportedEncodingException {
        this.FX = URLEncoder.encode(FX, "UTF-8");
    }
}
