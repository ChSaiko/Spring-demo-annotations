package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {

		// read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// get the bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);

		// thatSillyCoach is the bean(object)
		// if we don't chose the bean id, the default
		// bean id is the name of class by upperCase
		// NB: make sure that you use the best bean id

		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());

		// call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		// close the context
		context.close();

	}

}
