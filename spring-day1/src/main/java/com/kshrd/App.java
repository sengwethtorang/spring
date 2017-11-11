package com.kshrd;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
//		ClassPathXmlApplicationContext ctx = 
//				new ClassPathXmlApplicationContext("applicationContext.xml");
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloService hello = ctx.getBean(HelloService.class);
		hello.sayHi();
		
		System.out.println(ctx.getBeanDefinitionCount());
//		System.out.println(ctx.getBeanDefinitionNames().toString());

		
	}
}
