package com.ceyentra.springdemo;

import com.ceyentra.springdemo.beans.SwimCoach;
import com.ceyentra.springdemo.config.SportConfig;
import com.ceyentra.springdemo.interfaces.Coach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigAppDemo {
    public static void main(String[] args) {
        // load spring config file
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(SportConfig.class); // No More XML

        /*get the methods from the bean*/
        SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class); /**bean name == bean method name*/

        /*call a method on the bean*/
        System.out.println(theCoach.getDailyWorkout());

        /*call method to get daily fortune*/
        System.out.println(theCoach.getDailyFortune());

        // call our new swim coach methods...has the props values injected
        System.out.println("email: " + theCoach.getEmail());
        System.out.println("team: " + theCoach.getTeam());

        /*close the context*/
        context.close();
    }
}
