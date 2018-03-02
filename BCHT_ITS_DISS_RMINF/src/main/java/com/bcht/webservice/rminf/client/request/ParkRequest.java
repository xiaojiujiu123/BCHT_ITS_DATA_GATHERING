package com.bcht.webservice.rminf.client.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 停车场车辆信息写入接口参数类
 * Created by zyq on 2017/4/14.
 */
@XStreamAlias("park")
public class ParkRequest {
    private String TCCBH;//	停车场编号   不可空
    private String FXLX;//	方向类型	    不可空    1-驶入；2-驶出
    private String CRKBH;//出入口编号  不可空
    private String TXSJ;//  通行时间     不可空    格式:YYYY-MM-DD- HH24:MI:SS
    private String TCWZ;//	停车位置
    /**
     * 1大型汽车;2小型汽车;3使馆汽车;4	领馆汽车;5境外汽车;6外籍汽车;7普通摩托车;8轻便摩托车;9使馆摩托车;10领馆摩托车;
     11	境外摩托车;12	外籍摩托车;13	低速车;14拖拉机;15挂车;16	教练汽车;17教练摩托车;18试验汽车;19试验摩托车;20临时入境汽车;
     21	临时入境摩托车;22	临时行驶车;23	警用汽车;24警用摩托;25原农机号牌;26香港入出境车;27澳门入出境车;31武警号牌;32军队号牌;41	无号牌;
     42假号牌;43挪用号牌;44无法识别;99其他号牌;
     */
    private String HPZL;//	号牌种类    不可空 附录4.4
    private String HPHM;//	号牌号码    不可空
    private String HPYS;//	号牌颜色    0白色;1黄色;2蓝色;3黑色;4绿色;9其它颜色
    private String CSYS;//	车身颜色    A白;B灰;C黄;D粉;E红;F紫;G绿;H蓝;I棕;J黑;
    private String CLPP;//	车辆品牌
    private String CLLX;//	车辆类型    附录4.7
    private String TPLJ;//	图片路径
    private String TP1;//	图片名1
    private String TP2;//	图片名2
    private String TP3;//	图片名3

    public String getTCCBH() {
        return TCCBH;
    }

    public void setTCCBH(String TCCBH) throws UnsupportedEncodingException {
        this.TCCBH = URLEncoder.encode(TCCBH, "UTF-8");
    }

    public String getFXLX() {
        return FXLX;
    }

    public void setFXLX(String FXLX) throws UnsupportedEncodingException {
        this.FXLX = URLEncoder.encode(FXLX, "UTF-8");
    }
    public String getCRKBH() {
        return CRKBH;
    }

    public void setCRKBH(String CRKBH) throws UnsupportedEncodingException {
        this.CRKBH = URLEncoder.encode(CRKBH, "UTF-8");
    }
    public String getTXSJ() {
        return TXSJ;
    }

    public void setTXSJ(String TXSJ) throws UnsupportedEncodingException {
        this.TXSJ = URLEncoder.encode(TXSJ, "UTF-8");
    }

    public String getTCWZ() {
        return TCWZ;
    }

    public void setTCWZ(String TCWZ) throws UnsupportedEncodingException {
        this.TCWZ = URLEncoder.encode(TCWZ, "UTF-8");
    }

    public String getHPZL() {
        return HPZL;
    }

    public void setHPZL(String HPZL) throws UnsupportedEncodingException {
        this.HPZL = URLEncoder.encode(HPZL, "UTF-8");
    }

    public String getHPHM() {
        return HPHM;
    }

    public void setHPHM(String HPHM) throws UnsupportedEncodingException {
        this.HPHM = URLEncoder.encode(HPHM, "UTF-8");
    }

    public String getHPYS() {
        return HPYS;
    }

    public void setHPYS(String HPYS) throws UnsupportedEncodingException {
        this.HPYS = URLEncoder.encode(HPYS, "UTF-8");
    }

    public String getCSYS() {
        return CSYS;
    }

    public void setCSYS(String CSYS) throws UnsupportedEncodingException {
        this.CSYS = URLEncoder.encode(CSYS, "UTF-8");
    }

    public String getCLPP() {
        return CLPP;
    }

    public void setCLPP(String CLPP) throws UnsupportedEncodingException {
        this.CLPP = URLEncoder.encode(CLPP, "UTF-8");
    }

    public String getCLLX() {
        return CLLX;
    }

    public void setCLLX(String CLLX) throws UnsupportedEncodingException {
        this.CLLX = URLEncoder.encode(CLLX, "UTF-8");
    }

    public String getTPLJ() {
        return TPLJ;
    }

    public void setTPLJ(String TPLJ) throws UnsupportedEncodingException {
        this.TPLJ = URLEncoder.encode(TPLJ, "UTF-8");
    }

    public String getTP1() {
        return TP1;
    }

    public void setTP1(String TP1) throws UnsupportedEncodingException {
        this.TP1 = URLEncoder.encode(TP1, "UTF-8");
    }

    public String getTP2() {
        return TP2;
    }

    public void setTP2(String TP2) throws UnsupportedEncodingException {
        this.TP2 = URLEncoder.encode(TP2, "UTF-8");
    }

    public String getTP3() {
        return TP3;
    }

    public void setTP3(String TP3) throws UnsupportedEncodingException {
        this.TP3 = URLEncoder.encode(TP3, "UTF-8");
    }
}
