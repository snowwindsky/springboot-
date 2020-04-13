package com.sn.springboot;

import com.sn.springboot.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;


@SpringBootTest
class SpringBoot02ConfigApplicationTests {

	@Autowired
	Person person;

	@Autowired
	ApplicationContext ioc;

	@Test
	public void getHelloService(){
		boolean b = ioc.containsBean("helloService");
		System.out.println(b);
	}
	@Test
	void contextLoads() {
		System.out.println(person);
	}
}
