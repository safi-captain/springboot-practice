package com.safi.common;

/**
 * Created by xiefeng
 * Time 2018/12/5
 */
public interface CommonData {
    enum statusCode {
        statusCode100(100, "异常状态");
        private Integer code;
        private String desc;

        statusCode(Integer code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}
