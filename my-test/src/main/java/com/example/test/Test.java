package com.example.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xsh
 * @date : 2020-6-18 10:45
 * @description:
 */


public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Appconfig.class);
		applicationContext.getBean(TestService.class).test();
	}
}
