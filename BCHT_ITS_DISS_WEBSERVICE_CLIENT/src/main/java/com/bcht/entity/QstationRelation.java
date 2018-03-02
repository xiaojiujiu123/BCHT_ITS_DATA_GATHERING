package com.bcht.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 交警执法站关联卡口信息
 * Created by zyq on 2017/4/24.
 */
@XStreamAlias("qstationrelation")
public class QstationRelation {
    private String fwzbh;

    public String getFwzbh() {
        return fwzbh;
    }

    public void setFwzbh(String fwzbh) {
        this.fwzbh = fwzbh;
    }
}
