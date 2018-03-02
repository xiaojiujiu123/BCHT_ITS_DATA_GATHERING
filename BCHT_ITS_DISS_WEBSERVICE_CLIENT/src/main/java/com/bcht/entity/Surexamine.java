package com.bcht.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.apache.tomcat.util.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 非现场违法待审核写入请求的对象实体类
 * @author 陶诗德
 *
 */
@XStreamAlias("surexamine")
public class Surexamine {
	private String sbbh = "";//设备编号 非空
	private String zqmj = "";//执勤民警
	private String clfl = "";//车辆分类 非空
	private String hphm = "";//号牌号码 非空
	private String hpzl = "";//号牌种类 非空
	private String fzjg = "";//发证机关
	private String jdcsyr= "";//机动车所有人
	private String csys= "";//车身颜色
	private String clpp= "";//车辆品牌
	private String jtfs= "";//交通方式 当车辆分类为3-公安机牌证机动车 可为空，否则充许为空
	private String zsxzqh= "";//住所行政区划
	private String dh= "";//电话
	private String lxfs= "";//联系方式
	private String xcfw= "";//是否提供校车服务 0:未提供 1:提供
	private String xzqh= "";//违法地行政区划 如传入的设备编号已备案，允许为空，否则昧不能为空
	private String wfdd= "";//违法地点  如传入的设备编号已备案，允许为空，否则不能为空
	private String lddm= "";//路段代码公里数 如传入的设备编号已备案，允许为空，否则不能为空
	private String ddms= "";//地点米数 如传入的设备编号已备案，允许为空，否疾风暴雨不能为空
	private String wfdz= "";//违法地址 如传入的设备编号已备案，允许为空，否则不能为空
	private String wfsj= "";//违法时间 yyyy-MM-dd hh:mm:ss 非空
	private String wfsj1= "";//违法时	间1 区间测速抓拍的交通违法可采集
	private String wfxw= "";//违法行为 4位或5位代码
	private String scz= "";//实测值
	private String bzz= "";//标准值
	private String zpsl= "";//照片数量
	private String zpstr1= "";//照片1 非空 base64编码
	private String zpstr2= "";//照片2
	private String zpstr3= "";//照片3

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

	public String getHphm() {
		return hphm;
	}

	public void setHphm(String hphm) {
		this.hphm = hphm;
	}

	public String getHpzl() {
		return hpzl;
	}

	public void setHpzl(String hpzl) {
		this.hpzl = hpzl;
	}

	public String getFzjg() {
		return fzjg;
	}

	public void setFzjg(String fzjg) {
		this.fzjg = fzjg;
	}

	public String getJdcsyr() {
		return jdcsyr;
	}

	public void setJdcsyr(String jdcsyr) {
		this.jdcsyr = jdcsyr;
	}

	public String getCsys() {
		return csys;
	}

	public void setCsys(String csys) {
		this.csys = csys;
	}

	public String getClpp() {
		return clpp;
	}

	public void setClpp(String clpp) {
		this.clpp = clpp;
	}

	public String getJtfs() {
		return jtfs;
	}

	public void setJtfs(String jtfs) {
		this.jtfs = jtfs;
	}

	public String getZsxzqh() {
		return zsxzqh;
	}

	public void setZsxzqh(String zsxzqh) {
		this.zsxzqh = zsxzqh;
	}

	public String getDh() {
		return dh;
	}

	public void setDh(String dh) {
		this.dh = dh;
	}

	public String getLxfs() {
		return lxfs;
	}

	public void setLxfs(String lxfs) {
		this.lxfs = lxfs;
	}

	public String getXcfw() {
		return xcfw;
	}

	public void setXcfw(String xcfw) {
		this.xcfw = xcfw;
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
