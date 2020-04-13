package com.sn.springboot.config;

import com.sn.springboot.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloConfig {
    @Bean
//    此处的方法名 helloService 就是容器中这个组件的默认id
    public HelloService helloService(){
        System.out.println("此处返回一个helloService");
        return new HelloService();
    }
}
