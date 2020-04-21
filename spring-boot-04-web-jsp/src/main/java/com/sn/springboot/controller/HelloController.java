package com.sn.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("/success")
    public String success(Model model){
        model.addAttribute("msg","测试西悉尼");
        return "success";
    }
    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("msg","测试西悉尼");
        return "hello";
    }
}
