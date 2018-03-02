package com.bcht.its.commons.restfulbean;

/**
 * Restful接口返回消息
 */
public class RespResult {
    /**处理状态 1:成功 -1:失败*/
    private String code = "1";
    /**如果失败，对应失败具体描述*/
    private String message;
    private String status = "success";
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getMsg(){
        return this.message;
    }
}
