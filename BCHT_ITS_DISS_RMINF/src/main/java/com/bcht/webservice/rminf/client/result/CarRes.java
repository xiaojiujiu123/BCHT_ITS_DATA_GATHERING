package com.bcht.webservice.rminf.client.result;

import com.bcht.webservice.rminf.client.request.CarRequest;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by zyq on 2017/4/18.
 */
@XStreamAlias("root")
public class CarRes {
    @XStreamAlias("car")
    private CarRequest carRequest;

    public CarRequest getCarRequest() {
        return carRequest;
    }

    public void setCarRequest(CarRequest carRequest) {
        this.carRequest = carRequest;
    }
}
