package com.sn.springboot.cotroller;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("hello")
    public String hello(){
        return "hello02";
    }
}
