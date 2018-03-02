package com.bcht.webservice.rminf.client.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by zyq on 2017/5/2.
 */
@XStreamAlias("feedback")
public class FeedbackRequest {

    private String yjxh  ="";   //预警序号     不可为空
    private String ywlx	 ="";   //业务类型     不可为空          1-签收；2-反馈；3-签收反馈；
    private String qsjg	 ="";   //签收结果	               1-有效；2-无效
    private String sfcjlj="";	//是否出警拦截              0否 1是
    private String ljclqk="";	//拦截车辆情况              0未拦截到 1已拦截到
    private String wljdyy="";	//未拦截到原因              01 未发现车辆 02 车辆未停或强行闯卡 03 车辆掉头或绕行 09 其他
    private String chjg	 ="";   //是否嫌疑车辆             0 否 1是
    private String cljg	 ="";   //处置结果	              根据预警类型显示,见表6.1，可以多个如：“123”
    private String wsbh="";	//法律文书编号	    	  Cljg包含2时不能为空

    /*private String cfxylx="";	//处罚嫌疑类型	2	是	Cljg包含2时不能为空
    private String cfxyzlx="";	//处罚嫌疑子类型	2	是*/
    private String yjbm	 ="";   //移交部门	              部门中文名称，Cljg包含3时不能为空
    private String lxr	 ="";   //联系人	              Cljg包含3时不能为空
    private String lxdh	 ="";   //联系电话                Cljg包含3时不能为空
    private String jyw	 ="";   //文书校验位              是	Cljg包含2时不能为空
    private String wslb	 ="";   //文书类别                Cljg包含2时不能为空 1 简易程序处罚决定书 3 强制措施凭证 6 违法处理通知书
    private String wchyy="";	//非嫌疑车辆原因            根据预警类型显示，见表6.2，只能单选
    private String czqkms="";	//处置情况描述
    private String czdw	 ="";   //处置单位     不可为空
    private String czr	 ="";   //处置民警	   不可为空           民警姓名
    private String czsj	 ="";   //处置时间	   不可为空          YYYY-MM-DDHH24:MI:SS

    public String getYjxh() {
        return yjxh;
    }

    public void setYjxh(String yjxh) throws UnsupportedEncodingException {
        this.yjxh = URLEncoder.encode(yjxh, "UTF-8");
    }

    public String getYwlx() {
        return ywlx;
    }

    public void setYwlx(String ywlx) throws UnsupportedEncodingException {
        this.ywlx = URLEncoder.encode(ywlx, "UTF-8");
    }

    public String getQsjg() {
        return qsjg;
    }

    public void setQsjg(String qsjg) throws UnsupportedEncodingException {
        this.qsjg = URLEncoder.encode(qsjg, "UTF-8");
    }

    public String getSfcjlj() {
        return sfcjlj;
    }

    public void setSfcjlj(String sfcjlj) throws UnsupportedEncodingException {
        this.sfcjlj = URLEncoder.encode(sfcjlj, "UTF-8");
    }

    public String getLjclqk() {
        return ljclqk;
    }

    public void setLjclqk(String ljclqk) throws UnsupportedEncodingException {
        this.ljclqk = URLEncoder.encode(ljclqk, "UTF-8");
    }

    public String getWljdyy() {
        return wljdyy;
    }

    public void setWljdyy(String wljdyy) throws UnsupportedEncodingException {
        this.wljdyy = URLEncoder.encode(wljdyy, "UTF-8");
    }

    public String getChjg() {
        return chjg;
    }

    public void setChjg(String chjg) throws UnsupportedEncodingException {
        this.chjg = URLEncoder.encode(chjg, "UTF-8");
    }

    public String getCljg() {
        return cljg;
    }

    public void setCljg(String cljg) throws UnsupportedEncodingException {
        this.cljg = URLEncoder.encode(cljg, "UTF-8");
    }

    public String getWsbh() {
        return wsbh;
    }

    public void setWsbh(String wsbh) throws UnsupportedEncodingException {
        this.wsbh = URLEncoder.encode(wsbh, "UTF-8");
    }

    public String getJyw() {
        return jyw;
    }

    public void setJyw(String jyw) throws UnsupportedEncodingException {
        this.jyw = URLEncoder.encode(jyw, "UTF-8");
    }

    public String getWslb() {
        return wslb;
    }

    public void setWslb(String wslb) throws UnsupportedEncodingException {
        this.wslb = URLEncoder.encode(wslb, "UTF-8");
    }

    public String getYjbm() {
        return yjbm;
    }

    public void setYjbm(String yjbm) throws UnsupportedEncodingException {
        this.yjbm = URLEncoder.encode(yjbm, "UTF-8");
    }

    public String getLxr() {
        return lxr;
    }

    public void setLxr(String lxr) throws UnsupportedEncodingException {
        this.lxr = URLEncoder.encode(lxr, "UTF-8");
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) throws UnsupportedEncodingException {
        this.lxdh = URLEncoder.encode(lxdh, "UTF-8");
    }

    public String getWchyy() {
        return wchyy;
    }

    public void setWchyy(String wchyy) throws UnsupportedEncodingException {
        this.wchyy = URLEncoder.encode(wchyy, "UTF-8");
    }

    public String getCzqkms() {
        return czqkms;
    }

    public void setCzqkms(String czqkms) throws UnsupportedEncodingException {
        this.czqkms = URLEncoder.encode(czqkms, "UTF-8");
    }

    public String getCzdw() {
        return czdw;
    }

    public void setCzdw(String czdw) throws UnsupportedEncodingException {
        this.czdw = URLEncoder.encode(czdw, "UTF-8");
    }

    public String getCzr() {
        return czr;
    }

    public void setCzr(String czr) throws UnsupportedEncodingException {
        this.czr = URLEncoder.encode(czr, "UTF-8");
    }

    public String getCzsj() {
        return czsj;
    }

    public void setCzsj(String czsj) throws UnsupportedEncodingException {
        this.czsj = URLEncoder.encode(czsj, "UTF-8");
    }
    /*public String getCfxylx() {
        return cfxylx;
    }

    public void setCfxylx(String cfxylx) throws UnsupportedEncodingException {
        this.cfxylx = URLEncoder.encode(cfxylx, "UTF-8");
    }
    public String getCfxyzlx() {
        return cfxyzlx;
    }

    public void setCfxyzlx(String cfxyzlx) throws UnsupportedEncodingException {
        this.cfxyzlx = URLEncoder.encode(cfxyzlx, "UTF-8");
    }*/
}
