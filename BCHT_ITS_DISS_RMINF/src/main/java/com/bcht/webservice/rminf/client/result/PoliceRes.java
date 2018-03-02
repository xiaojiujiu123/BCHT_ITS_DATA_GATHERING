package com.bcht.webservice.rminf.client.result;

import com.bcht.webservice.rminf.client.request.PoliceRequest;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by zyq on 2017/4/18.
 */
@XStreamAlias("root")
public class PoliceRes {
    @XStreamAlias("police")
    private PoliceRequest policeRequest;

    public PoliceRequest getPoliceRequest() {
        return policeRequest;
    }

    public void setPoliceRequest(PoliceRequest policeRequest) {
        this.policeRequest = policeRequest;
    }
}
