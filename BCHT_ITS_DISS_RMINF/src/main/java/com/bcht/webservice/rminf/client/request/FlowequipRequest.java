package com.bcht.webservice.rminf.client.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 交通流量信息写入接口参数类
 * Created by zyq on 2017/4/14.
 */
@XStreamAlias("flowequip")
public class FlowequipRequest {
    private String SBBH;//设备编号  不可空
    private String FXLX;//方向类型 1-上行 2-下行
    private String TJSD;//统计时段  YYYYMMDDHH24 不可空
    private String TJZQS;//统计周期数 不可空
    private String TXCLS;//通行车辆总数 不可空
    private String DCS;//大车数
    private String XCS;//小车数
    private String PJSD;//平均速度  精确1位小数  单位：公里/小时  不可空
    private String PJCC;//平均车长  精确1位小数  单位：米
    private String PJCTSJ;//平均车头时距 单位：分钟
    private String PJCTJJ;//平均车头间距 单位：米
    private String PJPDCD;//平均排队长度 单位：米

    public String getSBBH() {
        return SBBH;
    }

    public void setSBBH(String SBBH) throws UnsupportedEncodingException {
        this.SBBH = URLEncoder.encode(SBBH, "UTF-8");
    }
    public String getFXLX() {
        return FXLX;
    }

    public void setFXLX(String FXLX) throws UnsupportedEncodingException {
        this.FXLX = URLEncoder.encode(FXLX, "UTF-8");
    }

    public String getTJSD() {
        return TJSD;
    }

    public void setTJSD(String TJSD) throws UnsupportedEncodingException {
        this.TJSD = URLEncoder.encode(TJSD, "UTF-8");
    }

    public String getTJZQS() {
        return TJZQS;
    }

    public void setTJZQS(String TJZQS) throws UnsupportedEncodingException {
        this.TJZQS = URLEncoder.encode(TJZQS, "UTF-8");
    }

    public String getTXCLS() {
        return TXCLS;
    }

    public void setTXCLS(String TXCLS) throws UnsupportedEncodingException {
        this.TXCLS = URLEncoder.encode(TXCLS, "UTF-8");
    }

    public String getDCS() {
        return DCS;
    }

    public void setDCS(String DCS) throws UnsupportedEncodingException {
            this.DCS = URLEncoder.encode(DCS, "UTF-8");
    }

    public String getXCS() {
        return XCS;
    }

    public void setXCS(String XCS) throws UnsupportedEncodingException {
        this.XCS = URLEncoder.encode(XCS, "UTF-8");
    }

    public String getPJSD() {
        return PJSD;
    }

    public void setPJSD(String PJSD) throws UnsupportedEncodingException {
        this.PJSD = URLEncoder.encode(PJSD, "UTF-8");
    }

    public String getPJCC() {
        return PJCC;
    }

    public void setPJCC(String PJCC) throws UnsupportedEncodingException {
        this.PJCC = URLEncoder.encode(PJCC, "UTF-8");
    }

    public String getPJCTSJ() {
        return PJCTSJ;
    }

    public void setPJCTSJ(String PJCTSJ) throws UnsupportedEncodingException {
        this.PJCTSJ = URLEncoder.encode(PJCTSJ, "UTF-8");
    }

    public String getPJCTJJ() {
        return PJCTJJ;
    }

    public void setPJCTJJ(String PJCTJJ) throws UnsupportedEncodingException {
        this.PJCTJJ = URLEncoder.encode(PJCTJJ, "UTF-8");
    }

    public String getPJPDCD() {
        return PJPDCD;
    }

    public void setPJPDCD(String PJPDCD) throws UnsupportedEncodingException {
        this.PJPDCD = URLEncoder.encode(PJPDCD, "UTF-8");
    }
}
