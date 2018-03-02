package com.bcht.webservice.rminf.client.result;

import com.bcht.webservice.rminf.client.request.FlowequipRequest;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by zyq on 2017/4/18.
 */
@XStreamAlias("root")
public class FlowequipRes {
    @XStreamAlias("flowequip")
    private FlowequipRequest flowequipRequest;

    public FlowequipRequest getFlowequipRequest() {
        return flowequipRequest;
    }

    public void setFlowequipRequest(FlowequipRequest flowequipRequest) {
        this.flowequipRequest = flowequipRequest;
    }
}
