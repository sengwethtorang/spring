package com.kshrd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class JavaBaseDemo {

	@Bean
	public HelloService hello() {
		return new HelloService();
	}
	
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaBaseDemo.class);
		ctx.getBean(HelloService.class).sayHi();
	}
}
