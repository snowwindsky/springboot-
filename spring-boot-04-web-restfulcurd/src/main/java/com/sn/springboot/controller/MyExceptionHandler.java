package com.sn.springboot.controller;

import com.sn.springboot.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {
//    浏览器客户端返回的都是json
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map handleException(Exception e){
//        Map<String,Object> map = new HashMap();
//        map.put("code","user.notExist");
//        map.put("message",e.getMessage());
//        return map;
//    }

    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request){
        Map<String,Object> map = new HashMap();
//        传入自己的错误状态码
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code","user.notExist");
        map.put("message","用户出错啦");
        request.setAttribute("exc",map);
        return "forward:/error";
    }


}
