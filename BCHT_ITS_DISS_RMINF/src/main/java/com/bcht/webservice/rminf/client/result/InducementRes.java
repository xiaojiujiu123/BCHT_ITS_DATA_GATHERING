package com.bcht.webservice.rminf.client.result;

import com.bcht.webservice.rminf.client.request.InducementRequest;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by zyq on 2017/4/18.
 */
@XStreamAlias("root")
public class InducementRes {
    @XStreamAlias("inducement")
    private InducementRequest inducementRequest;

    public InducementRequest getInducementRequest() {
        return inducementRequest;
    }

    public void setInducementRequest(InducementRequest inducementRequest) {
        this.inducementRequest = inducementRequest;
    }
}
