package com.bcht.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.apache.tomcat.util.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 拦截处置图片信息对象类
 * Created by zyq on 2017/5/3.
 */
@XStreamAlias("feedbackpic")
public class Feedbackpic {
    private String yjxh;//预警序号  不可为空
    private String tp1;//图片1      不可为空
    private String tp2;//图片2
    private String tp3;//图片3
    private String scdw;//上传单位  不可为空
    private String scr;//上传人     不可为空

    public String getYjxh() {
        return yjxh;
    }

    public void setYjxh(String yjxh) {
        this.yjxh = yjxh;
    }

    public String getTp1() {
        return tp1;
    }

    public void setTp1(String tp1) {
        this.tp1 = tp1;
    }

    public String getTp2() {
        return tp2;
    }

    public void setTp2(String tp2) {
        this.tp2 = tp2;
    }

    public String getTp3() {
        return tp3;
    }

    public void setTp3(String tp3) {
        this.tp3 = tp3;
    }

    public String getScdw() {
        return scdw;
    }

    public void setScdw(String scdw) {
        this.scdw = scdw;
    }

    public String getScr() {
        return scr;
    }

    public void setScr(String scr) {
        this.scr = scr;
    }
}
