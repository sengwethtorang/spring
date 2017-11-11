package com.kshrd.spring_core.configuration;

import org.springframework.context.annotation.Bean;

import com.kshrd.spring_core.service.Drawing;
import com.kshrd.spring_core.service.Remote;
import com.kshrd.spring_core_model.Lg;
import com.kshrd.spring_core_model.Sony;
import com.kshrd.spring_core_model.Sumsung;
import com.kshrd.spring_core_model.Traingle;

public class BeanConfiguration {
	
	/*@Bean
	public Traingle traingle() {
		Traingle traingle = new Traingle();
		traingle.setType("Traingle");
		return traingle;
	}
	
	@Bean
	public Drawing drawing() {
		
		Drawing drawing = new Drawing(traingle());
		//drawing.draw();
		return drawing;
	}*/
	
	
	@Bean
	public Sumsung sumsung() {
		return new Sumsung();
	}
	
	@Bean
	public Lg lg() {
		return new Lg();
	}
	
	@Bean
	public Sony sony() {
		return new Sony();
	}
	
	@Bean
	public Remote remote() {
		return new Remote(lg());
	}
}
