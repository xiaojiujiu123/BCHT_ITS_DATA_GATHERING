package com.bcht.webservice.vehicle.client.request;

import com.bcht.webservice.vehicle.client.utils.PropertiesUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.text.SimpleDateFormat;
import java.util.Date;

@XStreamAlias("info")
public class Info
{
  private String jkid = "62C01";

  private String jkxlh = PropertiesUtils.getValue("rminf_webservice_serializ");
  private String time;

  public String getJkid()
  {
    return this.jkid;
  }

  public void setJkid(String jkid) {
    this.jkid = jkid;
  }

  public String getJkxlh() {
    return this.jkxlh;
  }

  public void setJkxlh(String jkxlh) {
    this.jkxlh = jkxlh;
  }

  public String getTime() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    return sdf.format(new Date());
  }

  public void setTime(String time) {
    this.time = time;
  }
}