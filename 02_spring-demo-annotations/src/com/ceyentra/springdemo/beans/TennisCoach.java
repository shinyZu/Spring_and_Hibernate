package com.ceyentra.springdemo.beans;

import com.ceyentra.springdemo.interfaces.Coach;
import com.ceyentra.springdemo.interfaces.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component("thatSillyCoach")
@Component
//@Scope("prototype")
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TennisCoach implements Coach {

    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    /*@Autowired
    public TennisCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }*/
    public TennisCoach() {
        System.out.println(">> TennisCoach: inside default constructor");
    }

    /* define my init method - code will execute after constructor & after DI*/
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("TennisCoach: inside method - doMyStartupStuff");
    }

    /* define my destroy method - code will execute before bean is destroyed */
    @PreDestroy
    public void doMyCleanupStuffYoYo(){
        System.out.println("TennisCoach: inside method - doMyCleanupStuffYoYo");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    /*@Autowired
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println(">> TennisCoach: inside setter method");
        this.fortuneService = fortuneService;
    }*/

    /*@Autowired
    public void doSomeCrazyStuff(FortuneService fortuneService) {
        System.out.println(">> TennisCoach: inside doSomeCrazyStuff()");
        this.fortuneService = fortuneService;
    }*/




}
