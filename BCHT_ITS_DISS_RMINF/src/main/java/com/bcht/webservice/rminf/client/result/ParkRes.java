package com.bcht.webservice.rminf.client.result;

import com.bcht.webservice.rminf.client.request.ParkRequest;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by zyq on 2017/4/18.
 */
@XStreamAlias("root")
public class ParkRes {
    @XStreamAlias("park")
    private ParkRequest parkRequest;

    public ParkRequest getParkRequest() {
        return parkRequest;
    }

    public void setParkRequest(ParkRequest parkRequest) {
        this.parkRequest = parkRequest;
    }
}
