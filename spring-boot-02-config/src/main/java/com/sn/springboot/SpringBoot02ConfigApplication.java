package com.sn.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

//@ImportResource(locations = {"classpath:beans.xml"})//spring boot中不推荐该方式，而是使用注解
@SpringBootApplication
public class SpringBoot02ConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot02ConfigApplication.class, args);
	}

}
