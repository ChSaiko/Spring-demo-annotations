package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.luv2code.springdemo")
//we can write simply because enter the parenthes is optionel @ComponentScan
@PropertySource("classpath:sport.properties")
public class SportConfig {
	// we declarate our bean in this class because in the container has
	// AnnotationConfigApplicationContext(sport.class)
	
	// define bean for our sad fortune service

	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}

	// define bean for our swim coach AND inject dependency
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}

}
