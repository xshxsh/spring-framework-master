package com.example;

import com.example.config.Testconfig;
import com.example.service.TestService;
import org.junit.Test;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.util.Arrays;

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
		//创建简单注册器
		SimpleBeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();
		//创建bean定义读取器
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
		//获取资源
		ClassPathResource resource = new ClassPathResource("web.xml");
		//装载资源
		reader.loadBeanDefinitions(resource);
		String beans = Arrays.asList(registry.getBeanDefinitionNames()).toString();
		System.out.println(beans);

		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("web.xml");
		//User user = (User) context.getBean("user");
		//user.setName("小红");
		//System.out.println(user.getName());

	}
}
