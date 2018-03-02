package com.bcht.webservice.rminf.client.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by zyq on 2017/4/28.
 */
@XStreamAlias("qstationperson")
public class QstationpersonRequest {
    private String fwzbh;

    public String getFwzbh() {
        return fwzbh;
    }

    public void setFwzbh(String fwzbh) throws UnsupportedEncodingException {
        this.fwzbh = URLEncoder.encode(fwzbh, "UTF-8");
    }
}
