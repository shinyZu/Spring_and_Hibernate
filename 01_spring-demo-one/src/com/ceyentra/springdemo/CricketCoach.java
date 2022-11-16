package com.ceyentra.springdemo;

public class CricketCoach implements Coach {

    private FortuneService fortuneService;

    // add new fields for email & team
    private String emailAddress;
    private String team;

    public CricketCoach() {
        System.out.println("CricketCoach : inside no-arg constructor");
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getTeam() {
        return team;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 mins";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("CricketCoach : inside setter method - setFortuneService");
        this.fortuneService = fortuneService;
    }

    public void setEmailAddress(String emailAddress) {
        System.out.println("CricketCoach : inside setter method - setEmailAddress");
        this.emailAddress = emailAddress;
    }

    public void setTeam(String team) {
        System.out.println("CricketCoach : inside setter method - setTeam");
        this.team = team;
    }
}
