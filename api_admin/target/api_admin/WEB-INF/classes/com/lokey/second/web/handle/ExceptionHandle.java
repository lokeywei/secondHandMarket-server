package com.lokey.second.web.handle;

import com.lokey.second.web.result.Result;
import com.lokey.second.web.result.ResultEnums;
import com.lokey.second.web.result.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by lokey on 2017/8/22.
 */
@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(HttpServletRequest request, Exception e){
        e.printStackTrace();
        logger.error("method:{}",request.getRequestURI());
        logger.error("params:{}",showParamter(request.getParameterMap()));
        logger.error("error:{}",e.toString());
        return ResultUtil.error(e.getMessage()); //运行时错误
    }

    public static String showParamter(Map<String,String[]> map){
        String result = "";
        for (String key : map.keySet()) {
            String[] val  = map.get(key);
            result += key +":"+val[0] +" ";
        }
        return  result;
    }
}
