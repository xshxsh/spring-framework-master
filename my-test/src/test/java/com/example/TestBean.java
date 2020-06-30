package com.example;

import com.example.bean.User;
import com.example.config.Testconfig;
import com.example.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @author xsh
 * @date : 2020-6-18 10:45
 * @description:
 */


public class TestBean {

	@Test
	public void testService() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Testconfig.class);
		applicationContext.getBean(TestService.class).test();
	}

	@Test
	public void testBean() {
		//创建默认bean工厂
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		//创建bean定义读取器
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		//获取资源
		ClassPathResource resource = new ClassPathResource("web.xml");
		//装载资源
		reader.loadBeanDefinitions(resource);
		//获取bean
		User user = factory.getBean("user", User.class);
		user.setName("小红");
		System.out.println(user.getName());

	}
}
