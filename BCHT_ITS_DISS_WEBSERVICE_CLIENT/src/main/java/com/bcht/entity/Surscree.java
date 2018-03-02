package com.bcht.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.apache.tomcat.util.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


/**
 * 非现场违法待筛选写入接口的参数类
 * @author 陶诗德
 *
 */
@XStreamAlias("surscreen")
public class Surscree {
	private String sbbh;//设备编号 非空
	private String zqmj;//执勤民警  警员代号
	private String clfl;//车辆分类 必须为3-公安机牌证机动车；4-武警牌证机动车；5-部队牌证机动车；6-农机牌证机动车
	private String hpzl;//号牌种类
	private String hphm;//号牌号码
	//private String fzjg;//发证机关  当车辆分类为“3-公安机牌证机动车”可为空，否则不允许为空
	private String xzqh;//违法地点行政区划
	private String wfdd;//违法地点
	private String lddm;//路段代码 公里数
	private String ddms;//地点米数
	private String wfdz;//违法地址
	private String wfsj;//违法时间 不为空时格式为;yyyy-MM-dd hh:mm:ss
	private String wfsj1;//违法时间1 区间测速抓拍的交通行为可采集 可为空
	private String wfxw;//违法行为 4位或5位代码
	private String scz;//实测值
	private String bzz;//标准值
	private String zpsl;//照片数量 非空
	private String zpwjm;//照片文件名
	private String zpstr1;//照片1 非空 Base64编码 第一张不能为空
	private String zpstr2;//照片2
	private String zpstr3;//照片3


	public String getSbbh() {
		return sbbh;
	}

	public void setSbbh(String sbbh) {
		this.sbbh = sbbh;
	}

	public String getZqmj() {
		return zqmj;
	}

	public void setZqmj(String zqmj) {
		this.zqmj = zqmj;
	}

	public String getClfl() {
		return clfl;
	}

	public void setClfl(String clfl) {
		this.clfl = clfl;
	}

	public String getHpzl() {
		return hpzl;
	}

	public void setHpzl(String hpzl) {
		this.hpzl = hpzl;
	}

	public String getHphm() {
		return hphm;
	}

	public void setHphm(String hphm) {
		this.hphm = hphm;
	}

	public String getXzqh() {
		return xzqh;
	}

	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}

	public String getWfdd() {
		return wfdd;
	}

	public void setWfdd(String wfdd) {
		this.wfdd = wfdd;
	}

	public String getLddm() {
		return lddm;
	}

	public void setLddm(String lddm) {
		this.lddm = lddm;
	}

	public String getDdms() {
		return ddms;
	}

	public void setDdms(String ddms) {
		this.ddms = ddms;
	}

	public String getWfdz() {
		return wfdz;
	}

	public void setWfdz(String wfdz) {
		this.wfdz = wfdz;
	}

	public String getWfsj() {
		return wfsj;
	}

	public void setWfsj(String wfsj) {
		this.wfsj = wfsj;
	}

	public String getWfsj1() {
		return wfsj1;
	}

	public void setWfsj1(String wfsj1) {
		this.wfsj1 = wfsj1;
	}

	public String getWfxw() {
		return wfxw;
	}

	public void setWfxw(String wfxw) {
		this.wfxw = wfxw;
	}

	public String getScz() {
		return scz;
	}

	public void setScz(String scz) {
		this.scz = scz;
	}

	public String getBzz() {
		return bzz;
	}

	public void setBzz(String bzz) {
		this.bzz = bzz;
	}

	public String getZpsl() {
		return zpsl;
	}

	public void setZpsl(String zpsl) {
		this.zpsl = zpsl;
	}

	public String getZpwjm() {
		return zpwjm;
	}

	public void setZpwjm(String zpwjm) {
		this.zpwjm = zpwjm;
	}

	public String getZpstr1() {
		return zpstr1;
	}

	public void setZpstr1(String zpstr1) {
		this.zpstr1 = zpstr1;
	}

	public String getZpstr2() {
		return zpstr2;
	}

	public void setZpstr2(String zpstr2) {
		this.zpstr2 = zpstr2;
	}

	public String getZpstr3() {
		return zpstr3;
	}

	public void setZpstr3(String zpstr3) {
		this.zpstr3 = zpstr3;
	}
}
