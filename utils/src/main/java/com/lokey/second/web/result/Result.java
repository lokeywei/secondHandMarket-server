package com.lokey.second.web.result;

/**
 * Created by lokey on 2017/8/21.
 */
public class Result {
    public Integer code;

    public String msg;

    public Object data;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
