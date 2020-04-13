package com.sn.springboot.controller;

import com.sn.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user")String user){
        if("aaa".equals(user)){
            throw new UserNotExistException();
        }
        return "hello world!";
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> hello){
        hello.put("msg1","<h1>hello</h1>");
        hello.put("array1", Arrays.asList("张三","李四","王五"));
        return "success";
    }
}
