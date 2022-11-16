package com.ceyentra.springdemo;

public class HockeyCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice 6hrs a day";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}
