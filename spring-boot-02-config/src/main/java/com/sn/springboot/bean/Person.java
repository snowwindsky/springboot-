package com.sn.springboot.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 将配置文件中配置的每一个属性的值，映射到这个组件中
 * @ConfigurationProperties:告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定
 * prefix:配置文件中哪个下面的所有属性进行一一映射
 * 只有这个组件是容器中的组件，才能用容器提供的@ConfigurationProperties
 */
@Data
@ToString
@Component
@ConfigurationProperties(prefix = "person")
//@PropertySource(value = {"classpath:person.properties"})//用来指定读取配置文件
// 注意点：1.属性还是优先从application.properties和application.yml中读取，没有时才会从指定路径读取；
//2.指定配置文件必须为properties后缀的文件，为yml时无法获取对应内容
//@PropertySource(value = {"classpath:person.yml"})//无法获取其中属性
@Validated//开启校验
public class Person {
    @Value("${person.name}")
//    @Email//使用@ConfigurationProperties时才支持数据校验
    private String name;
    @Value("#{11*2}")
    private Integer age;
    private Boolean boss;
    private Date birth;

    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dog;
}
