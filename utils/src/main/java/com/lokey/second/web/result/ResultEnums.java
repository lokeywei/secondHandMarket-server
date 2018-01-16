package com.lokey.second.web.result;

/**
 * Created by lokey on 2017/8/21.
 */
public enum ResultEnums {
    SUCCESS(0,"请求成功"),
    SYSTEM_ERROR(1000,"系统内部错误"),
    VALID_ERROR(1001,"参数有误或为空");

    private int code;

    private String msg;

    ResultEnums(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
