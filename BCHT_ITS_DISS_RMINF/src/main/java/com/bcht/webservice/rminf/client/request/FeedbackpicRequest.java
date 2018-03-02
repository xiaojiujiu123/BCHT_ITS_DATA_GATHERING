package com.bcht.webservice.rminf.client.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * 拦截处置图片信息对象类
 * Created by zyq on 2017/5/3.
 */
@XStreamAlias("feedbackpic")
public class FeedbackpicRequest {
    private String yjxh;//预警序号  不可为空
    private String tp1;//图片1      不可为空
    private String tp2;//图片2
    private String tp3;//图片3
    private String scdw;//上传单位  不可为空
    private String scr;//上传人     不可为空

    public String getYjxh() {
        return yjxh;
    }

    public void setYjxh(String yjxh) throws UnsupportedEncodingException {
        this.yjxh = URLEncoder.encode(yjxh, "UTF-8");
    }

    public String getTp1() {
        return tp1;
    }

    public void setTp1(String tp1) throws UnsupportedEncodingException {
        this.tp1 = URLEncoder.encode(readFileBase64(tp1), "UTF-8");
    }

    public String getTp2() {
        return tp2;
    }

    public void setTp2(String tp2) throws UnsupportedEncodingException {
        this.tp2 = URLEncoder.encode(readFileBase64(tp2), "UTF-8");
    }

    public String getTp3() {
        return tp3;
    }

    public void setTp3(String tp3) throws UnsupportedEncodingException {
        this.tp3 = URLEncoder.encode(readFileBase64(tp3), "UTF-8");
    }

    public String getScdw() {
        return scdw;
    }

    public void setScdw(String scdw) throws UnsupportedEncodingException {
        this.scdw = URLEncoder.encode(scdw, "UTF-8");
    }

    public String getScr() {
        return scr;
    }

    public void setScr(String scr) throws UnsupportedEncodingException {
        this.scr = URLEncoder.encode(scr, "UTF-8");
    }

    public String readFileBase64(String str){
        byte[] datas =new byte[]{};
        if("".equals(str)){
            return "";
        }
        try {
            URL url =new URL(str);
            datas = IOUtils.toByteArray(url.openStream());
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return new BASE64Encoder().encode(datas);
    }
}
