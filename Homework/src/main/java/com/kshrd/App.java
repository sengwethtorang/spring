package com.kshrd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.kshrd.service.Travel;

/**
 * Hello world!
 *
 */
@ComponentScan
public class App 
{
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(App.class);
    	configApplicationContext.getBean(Travel.class).travelling();
    }
}
