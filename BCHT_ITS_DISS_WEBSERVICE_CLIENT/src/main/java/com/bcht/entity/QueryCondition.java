package com.bcht.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


/**
 * 客运车辆信息核查接口入参
 * @author 陶诗德
 *
 */
@XStreamAlias("QueryCondition")
public class QueryCondition {
	private String hpzl;
	private String hphm;

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
}
