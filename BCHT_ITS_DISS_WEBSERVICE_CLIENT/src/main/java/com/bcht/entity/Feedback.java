package com.bcht.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by zyq on 2017/5/2.
 */
@XStreamAlias("feedback")
public class Feedback {

    private String yjxh  ;   //预警序号     不可为空
    private String ywlx	 ;   //业务类型     不可为空          1-签收；2-反馈；3-签收反馈；
    private String qsjg	 ;   //签收结果	               1-有效；2-无效
    private String sfcjlj;	//是否出警拦截              0否 1是
    private String ljclqk;	//拦截车辆情况              0未拦截到 1已拦截到
    private String wljdyy;	//未拦截到原因              01 未发现车辆 02 车辆未停或强行闯卡 03 车辆掉头或绕行 09 其他
    private String chjg	 ;   //是否嫌疑车辆             0 否 1是
    private String cljg	 ;   //处置结果	              根据预警类型显示,见表6.1，可以多个如：“123”
    private String wsbh;	//法律文书编号	    	  Cljg包含2时不能为空
    private String jyw	 ;   //文书校验位              是	Cljg包含2时不能为空
    private String wslb	 ;   //文书类别                Cljg包含2时不能为空 1 简易程序处罚决定书 3 强制措施凭证 6 违法处理通知书
    private String yjbm	 ;   //移交部门	              部门中文名称，Cljg包含3时不能为空
    private String lxr	 ;   //联系人	              Cljg包含3时不能为空
    private String lxdh	 ;   //联系电话                Cljg包含3时不能为空
    private String wchyy;	//非嫌疑车辆原因            根据预警类型显示，见表6.2，只能单选
    private String czqkms;	//处置情况描述
    private String czdw	 ;   //处置单位     不可为空
    private String czr	 ;   //处置民警	   不可为空           民警姓名
    private String czsj	 ;   //处置时间	   不可为空          YYYY-MM-DDHH24:MI:SS

    public String getYjxh() {
        return yjxh;
    }

    public void setYjxh(String yjxh) {
        this.yjxh = yjxh;
    }

    public String getYwlx() {
        return ywlx;
    }

    public void setYwlx(String ywlx) {
        this.ywlx = ywlx;
    }

    public String getQsjg() {
        return qsjg;
    }

    public void setQsjg(String qsjg) {
        this.qsjg = qsjg;
    }

    public String getSfcjlj() {
        return sfcjlj;
    }

    public void setSfcjlj(String sfcjlj) {
        this.sfcjlj = sfcjlj;
    }

    public String getLjclqk() {
        return ljclqk;
    }

    public void setLjclqk(String ljclqk) {
        this.ljclqk = ljclqk;
    }

    public String getWljdyy() {
        return wljdyy;
    }

    public void setWljdyy(String wljdyy) {
        this.wljdyy = wljdyy;
    }

    public String getChjg() {
        return chjg;
    }

    public void setChjg(String chjg) {
        this.chjg = chjg;
    }

    public String getCljg() {
        return cljg;
    }

    public void setCljg(String cljg) {
        this.cljg = cljg;
    }

    public String getWsbh() {
        return wsbh;
    }

    public void setWsbh(String wsbh) {
        this.wsbh = wsbh;
    }

    public String getJyw() {
        return jyw;
    }

    public void setJyw(String jyw) {
        this.jyw = jyw;
    }

    public String getWslb() {
        return wslb;
    }

    public void setWslb(String wslb) {
        this.wslb = wslb;
    }

    public String getYjbm() {
        return yjbm;
    }

    public void setYjbm(String yjbm) {
        this.yjbm = yjbm;
    }

    public String getLxr() {
        return lxr;
    }

    public void setLxr(String lxr) {
        this.lxr = lxr;
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    public String getWchyy() {
        return wchyy;
    }

    public void setWchyy(String wchyy) {
        this.wchyy = wchyy;
    }

    public String getCzqkms() {
        return czqkms;
    }

    public void setCzqkms(String czqkms) {
        this.czqkms = czqkms;
    }

    public String getCzdw() {
        return czdw;
    }

    public void setCzdw(String czdw) {
        this.czdw = czdw;
    }

    public String getCzr() {
        return czr;
    }

    public void setCzr(String czr) {
        this.czr = czr;
    }

    public String getCzsj() {
        return czsj;
    }

    public void setCzsj(String czsj) {
        this.czsj = czsj;
    }
}
