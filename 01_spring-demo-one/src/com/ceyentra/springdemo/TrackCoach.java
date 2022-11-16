package com.ceyentra.springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;

	public TrackCoach() {
	}

	// add init method
	public void doMyStartupStuff(){
		System.out.println("TrackCoach: inside method - doMyStartupStuff");
	}

	public TrackCoach(FortuneService fortuneService){
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "Just DO It : " + this.fortuneService.getFortune();
	}

	// add a destroy method
	public void doMyCleanupStuffYoYo(){
		System.out.println("TrackCoach: inside method - doMyCleanupStuffYoYo");
	}
}










