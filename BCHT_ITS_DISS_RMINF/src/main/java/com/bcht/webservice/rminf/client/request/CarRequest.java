package com.bcht.webservice.rminf.client.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 警车定位信息写入接口参数类
 * Created by zyq on 2017/4/14.
 */
@XStreamAlias("car")
public class CarRequest {
    private String GPSBH;//GPS设备编号
    /**
     * 1大型汽车;2小型汽车;3使馆汽车;4	领馆汽车;5境外汽车;6外籍汽车;7普通摩托车;8轻便摩托车;9使馆摩托车;10领馆摩托车;
     11	境外摩托车;12	外籍摩托车;13	低速车;14拖拉机;15挂车;16	教练汽车;17教练摩托车;18试验汽车;19试验摩托车;20临时入境汽车;
     21	临时入境摩托车;22	临时行驶车;23	警用汽车;24警用摩托;25原农机号牌;26	香港入出境车;27澳门入出境车;31武警号牌;3241	无号牌;42假号牌;4344	无法识别;99	其他号牌;
     */
    private String HPZL;//号牌种类
    private String HPHM;//号牌号码
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
