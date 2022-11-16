package com.ceyentra.springdemo;

import com.ceyentra.springdemo.beans.PingPongCoach;
import com.ceyentra.springdemo.beans.SwimCoach;
import com.ceyentra.springdemo.interfaces.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {
        // load spring config file
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("applicationContext.xml");

        /*get the methods from the bean*/
        // Coach theCoach = context.getBean("tennisCoach", Coach.class);
        // Coach alphaCoach = context.getBean("pingPongCoach", Coach.class);
        // SwimCoach swimCoach = context.getBean("swimCoach", SwimCoach.class);
        // Coach pingPongCoach = context.getBean("pingPongCoach", Coach.class);
         PingPongCoach theCoach = context.getBean("pingPongCoach", PingPongCoach.class);

        /*call a method on the bean*/
         System.out.println(theCoach.getDailyWorkout());
        // System.out.println(alphaCoach.getDailyWorkout());

        /*call methods to test values injected using annotations*/
        // System.out.println(swimCoach.getEmail());
        // System.out.println(swimCoach.getTeam());

        /*call method to get daily fortune*/
         System.out.println(theCoach.getDailyFortune());
        // System.out.println(pingPongCoach.getDailyFortune());

        /*close the context*/
        context.close();
    }
}
