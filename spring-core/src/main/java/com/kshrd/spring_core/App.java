package com.kshrd.spring_core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kshrd.spring_core.configuration.BeanConfiguration;
import com.kshrd.spring_core.service.Drawing;
import com.kshrd.spring_core.service.Remote;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
    	/*ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("drawingContext.xml");
    	Remote drawing = ctx.getBean(Remote.class);
    	drawing.remoter();*/
    	
    	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfiguration.class);
    	Remote remote = ctx.getBean(Remote.class);
    	remote.remoter();
    }
}
