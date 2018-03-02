package com.bcht.webservice.rminf.client.result;

import com.bcht.webservice.rminf.client.request.FeedbackRequest;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by zyq on 2017/5/2.
 */
@XStreamAlias("root")
public class FeedbackRes {
    @XStreamAlias("feedback")
    private FeedbackRequest feedbackRequest;

    public FeedbackRequest getFeedbackRequest() {
        return feedbackRequest;
    }

    public void setFeedbackRequest(FeedbackRequest feedbackRequest) {
        this.feedbackRequest = feedbackRequest;
    }
}
