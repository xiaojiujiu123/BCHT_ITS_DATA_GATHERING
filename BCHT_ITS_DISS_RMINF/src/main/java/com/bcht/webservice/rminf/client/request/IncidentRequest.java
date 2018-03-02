package com.bcht.webservice.rminf.client.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * 交通事件信息写入接口参数类
 * Created by zyq on 2017/4/14.
 */
@XStreamAlias("incident")
public class IncidentRequest {
    private String SBLY;//设备来源  不可空 1-已备案的事件检测设备；2-已备案的视频摄像机；
    private String SBBH;//设备编号  不可空
    private String JCSJ;//检测时间  不可空 格式YYYY-MM-DD- HH24:MI:SS
    private String SJLX;//事件类型  不可空 A交通事故;B交通拥堵;C车辆逆行;D车辆停驶;E车辆横穿;F车辆超速;G车辆低速;H车行缓慢;I违规变道;J行人上高速;K行人横穿;
    private String TPXX1;//图片信息1 经base64编码后字符串
    private String TPXX2;//图片信息2 经base64编码后字符串
    private String SPXX;//视频信息   经base64编码后字符串

    public String getSBLY() {
        return SBLY;
    }

    public void setSBLY(String SBLY) throws UnsupportedEncodingException {
        this.SBLY = URLEncoder.encode(SBLY, "UTF-8");
    }

    public String getSBBH() {
        return SBBH;
    }

    public void setSBBH(String SBBH) throws UnsupportedEncodingException {
        this.SBBH = URLEncoder.encode(SBBH, "UTF-8");
    }

    public String getJCSJ() {
        return JCSJ;
    }

    public void setJCSJ(String JCSJ) throws UnsupportedEncodingException {
        this.JCSJ = URLEncoder.encode(JCSJ, "UTF-8");
    }

    public String getSJLX() {
        return SJLX;
    }

    public void setSJLX(String SJLX) throws UnsupportedEncodingException {
        this.SJLX = URLEncoder.encode(SJLX, "UTF-8");
    }

    public String getTPXX1() {
        return TPXX1;
    }

    public void setTPXX1(String TPXX1) throws UnsupportedEncodingException {
            this.TPXX1 = URLEncoder.encode(TPXX1, "UTF-8");
    }

    public String getTPXX2() {
        return TPXX2;
    }

    public void setTPXX2(String TPXX2) throws UnsupportedEncodingException {
            this.TPXX2 = URLEncoder.encode(TPXX2, "UTF-8");
    }

    public String getSPXX() {
        return SPXX;
    }

    public void setSPXX(String SPXX) throws UnsupportedEncodingException {
        this.SPXX = URLEncoder.encode(readFileBase64(SPXX), "UTF-8");
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
