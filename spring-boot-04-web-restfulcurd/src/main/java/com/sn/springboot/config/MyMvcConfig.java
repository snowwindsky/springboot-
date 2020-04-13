package com.sn.springboot.config;

import com.sn.springboot.component.LoginHandlerInterceptor;
import com.sn.springboot.component.MyLocaleResolver;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

//通过实现webMvcConfigurer接口拓展mvc功能
@Configuration
public class MyMvcConfig implements WebMvcConfigurer{

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送/sn请求，也来到success
        registry.addViewController("/sn").setViewName("success");
    }
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer adapter =new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

//          注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
//              静态资源： *.css,*.js
//              Spring Boot已经做好了静态资源映射
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                        .excludePathPatterns("/login.html","/","/user/login",
//                                "/asserts/**","/webjars/**");
            }
        };
        return adapter;
    }
    @Bean
    public LocaleResolver localeResolver(){
        return  new MyLocaleResolver();
    }
}
