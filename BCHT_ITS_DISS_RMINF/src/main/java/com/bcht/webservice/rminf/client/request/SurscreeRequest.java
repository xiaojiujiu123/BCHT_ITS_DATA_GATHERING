package com.bcht.webservice.rminf.client.request;

import com.bcht.webservice.rminf.client.PropertiesUtils;
import com.bcht.webservice.rminf.client.WebServiceClient;
import com.bcht.webservice.rminf.client.util.ImageUtil;
import com.bcht.webservice.rminf.client.util.PicUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.core.util.Base64Encoder;
import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 非现场违法待筛选写入接口的参数类
 * @author 陶诗德
 *
 */
@XStreamAlias("surscreen")
public class SurscreeRequest {
	private static Logger logger = LoggerFactory.getLogger(WebServiceClient.class);
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
	public void setSbbh(String sbbh) throws UnsupportedEncodingException{
		this.sbbh = URLEncoder.encode(sbbh, "UTF-8");
	}
	public String getZqmj() {
		return zqmj;
	}
	public void setZqmj(String zqmj) throws UnsupportedEncodingException {
		this.zqmj = URLEncoder.encode(zqmj,"UTF-8");
	}
	public String getClfl() {
		return clfl;
	}
	public void setClfl(String clfl) throws UnsupportedEncodingException {
		this.clfl = URLEncoder.encode(clfl,"UTF-8");
	}
	public String getHpzl() {
		return hpzl;
	}
	public void setHpzl(String hpzl) throws UnsupportedEncodingException {
		this.hpzl = URLEncoder.encode(hpzl,"UTF-8");
	}
	public String getHphm() {
		return hphm;
	}
	public void setHphm(String hphm) throws UnsupportedEncodingException {
		this.hphm = URLEncoder.encode(hphm,"UTF-8");
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
	public void setWfsj1(String wfsj1) throws UnsupportedEncodingException {
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
	public String getZpwjm() {
		return zpwjm;
	}
	public void setZpwjm(String zpwjm) throws UnsupportedEncodingException {
		this.zpwjm = URLEncoder.encode(zpwjm,"UTF-8");
	}
	public String getZpstr1() {
		return zpstr1;
	}
	public void setZpstr1(String zpstr1) throws UnsupportedEncodingException {
		this.zpstr1 = URLEncoder.encode(readFileBase64(zpstr1),"UTF-8");
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

	/*//海南州专用
	public String readFileBase64(String str){
		byte[] datas =new byte[]{};
		if("".equals(str)){
			return "";
		}
		//原图片地址
		String picUrl = "";
		try {
			picUrl = ImageUtil.ToBdImage(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//目标图片地址
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String piccUrl = PropertiesUtils.getValue("piccUrl")+sdf.format(new Date())+".jpg";
		PicUtils.commpressPicForScale(picUrl,piccUrl,500,0.8);
		File file = new File(piccUrl);
		try {
			URL url = new URL("file:///"+file.getPath());
			datas = IOUtils.toByteArray(url.openStream());
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
		File file1 = new File(picUrl);
		file1.delete();
		file.delete();
		return new  BASE64Encoder().encode(datas);
	}*/
	public String readFileBase64(String str){
		byte[] datas =new byte[]{};
		if("".equals(str)){
			return "";
		}
		try {
			URL url =new URL(str);
			logger.info("图片URL:"+url);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setConnectTimeout(30000);
			conn.setReadTimeout(30000);
			InputStream in = conn.getInputStream();

			datas = IOUtils.toByteArray(in);
			logger.info("hhhhhhhh");
			if(in!=null){
				in.close();
			}else{
				logger.error("图片数据为空!");
			}
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
		return new  BASE64Encoder().encode(datas);
	}
}
