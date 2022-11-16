package com.ceyentra.springdemo;

import com.ceyentra.springdemo.config.SportConfig;
import com.ceyentra.springdemo.interfaces.Coach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigAppDemo {
    public static void main(String[] args) {
        // load spring config file
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(SportConfig.class); // No More XML

        /*get the methods from the bean*/
        Coach theCoach = context.getBean("tennisCoach", Coach.class);

        /*call a method on the bean*/
        System.out.println(theCoach.getDailyWorkout());

        /*call method to get daily fortune*/
        System.out.println(theCoach.getDailyFortune());

        /*close the context*/
        context.close();
    }
}
