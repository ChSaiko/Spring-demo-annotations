package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {

		// read spring config file
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);

		// get the bean from spring container
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);

		// thatSillyCoach is the bean(object)
		// if we don't chose the bean id, the default
		// bean id is the name of class by upperCase
		// NB: make sure that you use the best bean id

		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());

		// call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());

		// call our new swim coach methods ... has the props value injected

		System.out.println(("email: " + theCoach.getEmail()));
		System.out.println(("team: " + theCoach.getTeam()));

		// close the context
		context.close();

	}

}
