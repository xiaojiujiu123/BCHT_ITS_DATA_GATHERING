package com.bcht.webservice.rminf.client.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 交警执法站信息
 * Created by zyq on 2017/4/24.
 */
@XStreamAlias("qstation")
public class QstationRequest {
    private String glbmt;

    public String getGlbmt() {
        return glbmt;
    }

    public void setGlbmt(String glbmt) throws UnsupportedEncodingException {
        this.glbmt = URLEncoder.encode(glbmt, "UTF-8");
    }
}
