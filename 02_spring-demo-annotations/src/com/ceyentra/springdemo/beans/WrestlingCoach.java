package com.ceyentra.springdemo.beans;
import com.ceyentra.springdemo.interfaces.Coach;
import com.ceyentra.springdemo.interfaces.FortuneService;
public class WrestlingCoach implements Coach {
    private FortuneService fortuneService;

    public WrestlingCoach(FortuneService theFortuneService) {
        fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your double leg take down.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
