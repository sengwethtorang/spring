package com.kshrd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.kshrd.model.Message;
import com.kshrd.service.Messager;



@ComponentScan()
public class App 
{
    @SuppressWarnings("resource")
	public static void main( String[] args )
    {
   	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
//    	Message message = ctx.getBean("message", Message.class);
//    	Message message = ctx.getBean(Message.class);
    	//message.setMessage("Hi");
    	Messager messager = ctx.getBean(Messager.class);
    	messager.send();
    }
}
