package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {
	
	private FortuneService fortuneService;
	
	//here we injecte the value in our attribue "email", the value is the properties file 
	@Value("${foo.email}")
	private String email;
	//here we injecte the value in our attribue "team"
	@Value("${foo.team}")
	private String team;
	
	
	
	public String getEmail() {
		return email;
	}
	public String getTeam() {
		return team;
	}
	//we define a constructor
	public SwimCoach(FortuneService theFortuneService) {
		fortuneService=theFortuneService;
	}
	@Override
	public String getDailyWorkout() {
		return "Swim 100 meters as a warm up";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
