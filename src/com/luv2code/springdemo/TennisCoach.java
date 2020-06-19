package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

	//@Component("thatSillyCoach")

	@Component // here spring take the default bean id
	//if we don't give the nature of scope spring will take by default the singleton scope
	@Scope("prototype")
	public class TennisCoach implements Coach {

	@Autowired // this is type of injection dependency is Field Injection
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

	// step 1: we create our interface and our class and we add attrubie of the
	// interface
	// step 2:create the constructor

	// define a default constructor
	public TennisCoach() {
		System.out.println(">>TennisCoach: inside default constructor");
	}

	// define a setter method:injection dependency by setter method

	// public void setFortuneService(FortuneService thefortuneService) {
	// here we change the name of the setter method() the esensiel think that we
	// declare a annotation @Autowired on the setter method

	/*
	 * @Autowired // step 2 add @Autowired public void doSomthing(FortuneService
	 * thefortuneService) {
	 * System.out.println(">>TennisCoach: inside setFortuneService() method");
	 * fortuneService = thefortuneService; } this type of DoI named method injection
	 * the principe is to rename the methode setter by any name but take the same
	 * signature and also we can add other service
	 */

	/*
	 * step2: in the constructor injection
	 * 
	 * @Autowired // type of injection of dependency: constructor injections public
	 * public TennisCoach(FortuneService thefortuneService) { fortuneService =
	 * thefortuneService; }
	 */
	// define my init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">>TennisCoach:inside of doMyStartupStuff");
		System.out.println(fortuneService.getFortune());
	}

	// define my destroy method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">>TennisCoach:inside of doMyCleanupStuff");
	}

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {

		return fortuneService.getFortune();
	}

}
