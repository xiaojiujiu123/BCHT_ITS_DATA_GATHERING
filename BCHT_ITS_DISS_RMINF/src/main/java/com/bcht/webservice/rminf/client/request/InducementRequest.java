package com.bcht.webservice.rminf.client.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * 交通诱导发布信息写入接口参数类
 * Created by zyq on 2017/4/14.
 */
@XStreamAlias("inducement")
public class InducementRequest {
    private String SBBH;//	设备编号     不可空
    private String FBSJ;//	发布时间	    不可空     格式YYYY-MM-DD- HH24:MI:SS
    private String XXLX;//	信息类型	    不可空     1交通路况信息;2交通管制信息;3道路施工信息;4交通事故信息;5交通事件信息;6停车场位信息;9其他发布信息
    private String FBFS;//	发布方式	    不可空     1立即;2延时;3定时
    private String QSSJ;//	起始时间	    格式YYYY-MM-DD- HH24:MI:SS
    private String JSSJ;//	结束时间	    格式YYYY-MM-DD- HH24:MI:SS
    private String FBNR;//	发布内容     不可空
    private String TPXX1;//	图片信息	    经base64编码后字符串
    private String TPXX2;//	图片信息	    经base64编码后字符串
    private String JLZT;//	记录状态	    不可空     1-正常；0-作废
    private String FBYH;//	发布用户	    不可空     发布人姓名

    public String getSBBH() {
        return SBBH;
    }

    public void setSBBH(String SBBH) throws UnsupportedEncodingException {
        this.SBBH = URLEncoder.encode(SBBH, "UTF-8");
    }

    public String getFBSJ() {
        return FBSJ;
    }

    public void setFBSJ(String FBSJ) throws UnsupportedEncodingException {
        this.FBSJ = URLEncoder.encode(FBSJ, "UTF-8");
    }

    public String getXXLX() {
        return XXLX;
    }

    public void setXXLX(String XXLX) throws UnsupportedEncodingException {
        this.XXLX = URLEncoder.encode(XXLX, "UTF-8");
    }

    public String getFBFS() {
        return FBFS;
    }

    public void setFBFS(String FBFS) throws UnsupportedEncodingException {
        this.FBFS = URLEncoder.encode(FBFS, "UTF-8");
    }

    public String getQSSJ() {
        return QSSJ;
    }

    public void setQSSJ(String QSSJ) throws UnsupportedEncodingException {
        this.QSSJ = URLEncoder.encode(QSSJ, "UTF-8");
    }

    public String getJSSJ() {
        return JSSJ;
    }

    public void setJSSJ(String JSSJ) throws UnsupportedEncodingException {
        this.JSSJ = URLEncoder.encode(JSSJ, "UTF-8");
    }

    public String getFBNR() {
        return FBNR;
    }

    public void setFBNR(String FBNR) throws UnsupportedEncodingException {
        this.FBNR = URLEncoder.encode(FBNR, "UTF-8");
    }

    public String getTPXX1() {
        return TPXX1;
    }

    public void setTPXX1(String TPXX1) throws UnsupportedEncodingException {
        this.TPXX1 = URLEncoder.encode(readFileBase64(TPXX1), "UTF-8");
    }

    public String getTPXX2() {
        return TPXX2;
    }

    public void setTPXX2(String TPXX2) throws UnsupportedEncodingException {
        this.TPXX2 = URLEncoder.encode(readFileBase64(TPXX2), "UTF-8");
    }

    public String getJLZT() {
        return JLZT;
    }

    public void setJLZT(String JLZT) throws UnsupportedEncodingException {
        this.JLZT = URLEncoder.encode(JLZT, "UTF-8");
    }

    public String getFBYH() {
        return FBYH;
    }

    public void setFBYH(String FBYH) throws UnsupportedEncodingException {
        this.FBYH = URLEncoder.encode(FBYH, "UTF-8");
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
