package com.lokey.second.web.result;


/**
 * Created by lokey on 2017/8/21.
 */
public class ResultUtil {

    public static Result success(Object data){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("请求成功");
        result.setData(data);
        return  result;
    }

    public static Result error(String msg){
        Result result = new Result();
        result.setCode(1);
        result.setMsg(msg);
        return  result;
    }
}
