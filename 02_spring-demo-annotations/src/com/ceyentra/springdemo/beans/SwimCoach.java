package com.ceyentra.springdemo.beans;

import com.ceyentra.springdemo.interfaces.Coach;
import com.ceyentra.springdemo.interfaces.FortuneService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/** No @Component-introduced to context in SportConfig using @Bean*/
public class SwimCoach implements Coach {

    @Value("${foo.email}")
    private String email;

    @Value("${foo.team}")
    private String team;

    private FortuneService fortuneService;

/** No @Autowired - DI done by Inter-bean Dependency in SportConfig*/
    public SwimCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters as a warm up.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
