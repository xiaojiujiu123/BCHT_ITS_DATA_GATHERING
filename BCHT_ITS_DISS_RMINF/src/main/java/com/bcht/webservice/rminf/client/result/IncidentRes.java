package com.bcht.webservice.rminf.client.result;

import com.bcht.webservice.rminf.client.request.IncidentRequest;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by zyq on 2017/4/18.
 */
@XStreamAlias("root")
public class IncidentRes {
    @XStreamAlias("incident")
    private IncidentRequest incidentRequest;

    public IncidentRequest getIncidentRequest() {
        return incidentRequest;
    }

    public void setIncidentRequest(IncidentRequest incidentRequest) {
        this.incidentRequest = incidentRequest;
    }
}
