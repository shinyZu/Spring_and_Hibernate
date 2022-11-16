package com.ceyentra.springdemo;

public class GolfCoach implements Coach{
    private FortuneService fortuneService;

    public GolfCoach(FortuneService theFortuneService) {
        fortuneService = theFortuneService;
    }

    // add init method
    public void doMyStartupStuff(){
        System.out.println("GolfCoach: inside method - doMyStartupStuff");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your putting skills for 2 hours today";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    // add a destroy method
    public void doMyCleanupStuffYoYo(){
        System.out.println("GolfCoach: inside method - doMyCleanupStuffYoYo");
    }
}
