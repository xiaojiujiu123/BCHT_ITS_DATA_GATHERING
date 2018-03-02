package com.bcht.webservice.vehicle.client.result;


import com.bcht.webservice.vehicle.client.request.VehicleinfoRequest;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by zyq on 2017/5/15.
 */
@XStreamAlias("root")
public class VehicleinfoRes {
    @XStreamAlias("vehicleinfo")
    private VehicleinfoRequest vehicleinfoRequest;

    public VehicleinfoRequest getVehicleinfoRequest() {
        return vehicleinfoRequest;
    }

    public void setVehicleinfoRequest(VehicleinfoRequest vehicleinfoRequest) {
        this.vehicleinfoRequest = vehicleinfoRequest;
    }
}
