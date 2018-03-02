package com.bcht.webservice.rminf.client.request;

import com.bcht.webservice.rminf.client.util.ImageUtil;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.codec.binary.StringUtils;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * 非现场违法待审核写入请求的对象实体类
 * @author 陶诗德
 *
 */
@XStreamAlias("surexamine")
public class SurexamineRequest {
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
	public void setSbbh(String sbbh) throws UnsupportedEncodingException {
		this.sbbh = URLEncoder.encode(sbbh,"UTF-8");
	}
	public String getZqmj() {
		return zqmj;
	}
	public void setZqmj(String zqmj) throws UnsupportedEncodingException {
		this.zqmj = URLEncoder.encode(zqmj,"UTF-8");;
	}
	public String getClfl() {
		return clfl;
	}
	public void setClfl(String clfl) throws UnsupportedEncodingException {
		this.clfl = URLEncoder.encode(clfl,"UTF-8");
	}
	public String getHphm() {
		return hphm;
	}
	public void setHphm(String hphm) throws UnsupportedEncodingException {
		this.hphm = URLEncoder.encode(hphm,"UTF-8");
	}
	public String getHpzl() {
		return hpzl;
	}
	public void setHpzl(String hpzl) throws UnsupportedEncodingException {
		this.hpzl = URLEncoder.encode(hpzl,"UTF-8");
	}
	public String getFzjg() {
		return fzjg;
	}
	public void setFzjg(String fzjg) throws UnsupportedEncodingException{
		this.fzjg = URLEncoder.encode(fzjg,"UTF-8");
	}
	public String getJdcsyr() {
		return jdcsyr;
	}
	public void setJdcsyr(String jdcsyr) throws UnsupportedEncodingException{
		this.jdcsyr = URLEncoder.encode(jdcsyr,"UTF-8");
	}
	public String getCsys() {
		return csys;
	}
	public void setCsys(String csys) throws UnsupportedEncodingException{
		this.csys = URLEncoder.encode(csys,"UTF-8");
	}
	public String getClpp() {
		return clpp;
	}
	public void setClpp(String clpp) throws UnsupportedEncodingException{
		this.clpp = URLEncoder.encode(clpp,"UTF-8");
	}
	public String getJtfs() {
		return jtfs;
	}
	public void setJtfs(String jtfs) throws UnsupportedEncodingException{
		this.jtfs =  URLEncoder.encode(jtfs,"UTF-8");
	}
	public String getZsxzqh() {
		return zsxzqh;
	}
	public void setZsxzqh(String zsxzqh) throws UnsupportedEncodingException{
		this.zsxzqh = URLEncoder.encode(zsxzqh,"UTF-8");
	}
	public String getDh() {
		return dh;
	}
	public void setDh(String dh) throws UnsupportedEncodingException{
		this.dh = URLEncoder.encode(dh,"UTF-8");
	}
	public String getLxfs() {
		return lxfs;
	}
	public void setLxfs(String lxfs) throws UnsupportedEncodingException{
		this.lxfs = URLEncoder.encode(lxfs,"UTF-8");
	}
	public String getXcfw() {
		return xcfw;
	}
	public void setXcfw(String xcfw) throws UnsupportedEncodingException {
		this.xcfw = URLEncoder.encode(xcfw,"UTF-8");
	}
	public String getXzqh() {
		return xzqh;
	}
	public void setXzqh(String xzqh) throws UnsupportedEncodingException {
		this.xzqh = URLEncoder.encode(xzqh,"UTF-8");
	}
	public String getWfdd() {
		return wfdd;
	}
	public void setWfdd(String wfdd) throws UnsupportedEncodingException {
		this.wfdd = URLEncoder.encode(wfdd,"UTF-8");
	}
	public String getLddm() {
		return lddm;
	}
	public void setLddm(String lddm) throws UnsupportedEncodingException {
		this.lddm = URLEncoder.encode(lddm,"UTF-8");
	}
	public String getDdms() {
		return ddms;
	}
	public void setDdms(String ddms) throws UnsupportedEncodingException {
		this.ddms = URLEncoder.encode(ddms,"UTF-8");
	}
	public String getWfdz() {
		return wfdz;
	}
	public void setWfdz(String wfdz) throws UnsupportedEncodingException {
		this.wfdz = URLEncoder.encode(wfdz,"UTF-8");
	}
	public String getWfsj() {
		return wfsj;
	}
	public void setWfsj(String wfsj) throws UnsupportedEncodingException {
		this.wfsj = URLEncoder.encode(wfsj,"UTF-8");
	}
	public String getWfsj1() {
		return wfsj1;
	}
	public void setWfsj1(String wfsj1) throws UnsupportedEncodingException{
		this.wfsj1 = URLEncoder.encode(wfsj1,"UTF-8");
	}
	public String getWfxw() {
		return wfxw;
	}
	public void setWfxw(String wfxw) throws UnsupportedEncodingException {
		this.wfxw = URLEncoder.encode(wfxw,"UTF-8");
	}
	public String getScz() {
		return scz;
	}
	public void setScz(String scz) throws UnsupportedEncodingException {
		this.scz = URLEncoder.encode(scz,"UTF-8");
	}
	public String getBzz() {
		return bzz;
	}
	public void setBzz(String bzz) throws UnsupportedEncodingException {
		this.bzz = URLEncoder.encode(bzz,"UTF-8");
	}
	public String getZpsl() {
		return zpsl;
	}
	public void setZpsl(String zpsl) throws UnsupportedEncodingException {
		this.zpsl = URLEncoder.encode(zpsl,"UTF-8");
	}
	public String getZpstr1() {
		return zpstr1;
	}
	public void setZpstr1(String zpstr1) throws UnsupportedEncodingException {
		this.zpstr1 = URLEncoder.encode(readFileBase64(zpstr1),"UTF-8");//URLEncoder.encode(zpstr1,"UTF-8");
	}
	public String getZpstr2() {
		return zpstr2;
	}
	public void setZpstr2(String zpstr2) throws UnsupportedEncodingException {
			this.zpstr2 = URLEncoder.encode(readFileBase64(zpstr2),"UTF-8");
	}
	public String getZpstr3() {
		return zpstr3;
	}
	public void setZpstr3(String zpstr3) throws UnsupportedEncodingException {
			this.zpstr3 = URLEncoder.encode(readFileBase64(zpstr3),"UTF-8");
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
			return "";
		}
		return new BASE64Encoder().encode(datas);
	}
	
}
