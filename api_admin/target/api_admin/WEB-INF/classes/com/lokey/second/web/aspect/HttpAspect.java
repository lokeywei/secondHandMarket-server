package com.lokey.second.web.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by lokey on 2017/8/21.
 */
@Aspect
@Component
public class HttpAspect {


    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
    //切入点
    @Pointcut("execution(public * com.lokey.second.web.controller.*.*(..))")
    private void auth(){

    }

    @Before("auth()")
    private void before(JoinPoint joinPoint) throws Exception {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("----url={}",request.getRequestURL());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类名 、 类方法
        logger.info("method_class={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        Map paramterMap = request.getParameterMap();
        logger.info("args={}",showParamter(paramterMap));
    }


    public String showParamter(Map<String,String[]> map){
        String result = "";
        for (String key : map.keySet()) {
            String[] val  = map.get(key);
            result += key +":"+val[0] +" ";
        }
        return  result;
    }

}
