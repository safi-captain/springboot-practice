package com.safi.utils;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

/**
 * 前端ajax调用时，返回的消息，表示本次ajax调用是否成功
 */
@SuppressWarnings("serial")
public class JsonData implements Serializable {
    public static final Integer STATUS_SUCCESS = 0;
    public static final Integer STATUS_FAIL = 1;
    public static final String STATUS_SUCCESS_MSG = "操作成功";
    public static final String STATUS_FIAL_MSG = "操作失败";
    // 0 - 成功， 其他值 - 失败
    private Integer status = STATUS_SUCCESS;
    private String msg;
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private Object data;

    public JsonData() {
    }

    public JsonData(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 获取给定错误消息的失败状态的JsonMessage
     */
    public static JsonData getFailed(String msg) {
        return new JsonData(STATUS_FAIL, msg, null);
    }

    public static JsonData getFailed() {
        return new JsonData(STATUS_FAIL, STATUS_FIAL_MSG, null);
    }

    /**
     * 获取给定结果对象的成功状态的JsonMessage
     */
    public static JsonData getSucceed() {
        return new JsonData(STATUS_SUCCESS, STATUS_SUCCESS_MSG, null);
    }

    public static JsonData getSucceed(Object data) {
        return new JsonData(STATUS_SUCCESS, STATUS_SUCCESS_MSG, data);
    }

    public static JsonData getSucceed(String msg, Object data) {
        return new JsonData(STATUS_SUCCESS, msg, data);
    }

    public Integer getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

}
