package com.safi.utils.exception;

/**
 * Created by xiefeng
 * Time 2018/11/30
 */
public class FirstException extends MyBaseException {
    public FirstException() {
        super("第一个异常");
    }

    public FirstException(String msg) {
        super(msg);
    }
}
