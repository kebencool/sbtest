package com.kevin.sbtest.common.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ResponseBody
//controller只作用在requestmapping上
@ControllerAdvice
public class MyExceptionAdvice {

    @ExceptionHandler(value = Exception.class)
    public Map<String,Object> errorHandler(Exception e){
        Map<String ,Object> map = new HashMap<>();
        map.put("code",100);
        map.put("msg",e.getMessage());
        map.put("stackTrace",e.getStackTrace());
        return map;

    }

}

