package com.safi.utils.exception;

/**
 * Created by xiefeng
 * Time 2018/11/30
 */
public class MyBaseException extends RuntimeException {
    public MyBaseException() {
        super("普通异常");
    }

    public MyBaseException(String msg) {
        super(msg);
    }
}
