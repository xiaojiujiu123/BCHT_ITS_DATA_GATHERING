package com.bcht.webservice.rminf.client.result;

import com.bcht.webservice.rminf.client.request.FeedbackRequest;
import com.bcht.webservice.rminf.client.request.FeedbackpicRequest;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by zyq on 2017/5/3.
 */
@XStreamAlias("root")
public class FeedbackpicRes {
    @XStreamAlias("feedbackpic")
    private FeedbackpicRequest feedbackpicRequest;

    public FeedbackpicRequest getFeedbackpicRequest() {
        return feedbackpicRequest;
    }

    public void setFeedbackpicRequest(FeedbackpicRequest feedbackpicRequest) {
        this.feedbackpicRequest = feedbackpicRequest;
    }
}
