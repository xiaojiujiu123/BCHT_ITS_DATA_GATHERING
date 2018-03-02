package com.bcht.webservice.rminf.client.result;

import com.bcht.webservice.rminf.client.request.QstationpersonRequest;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by zyq on 2017/4/28.
 */
@XStreamAlias("root")
public class QstationpersonRes {
    @XStreamAlias("qstationperson")
    private QstationpersonRequest qstationpersonRequest;

    public QstationpersonRequest getQstationpersonRequest() {
        return qstationpersonRequest;
    }

    public void setQstationpersonRequest(QstationpersonRequest qstationpersonRequest) {
        this.qstationpersonRequest = qstationpersonRequest;
    }
}
