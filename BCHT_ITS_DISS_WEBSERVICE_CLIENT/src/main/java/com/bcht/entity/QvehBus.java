package com.bcht.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@XStreamAlias("qvehbus")
public class QvehBus {
	private String hphm;//号牌号码
	private String hpzl;//号牌种类

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
}
