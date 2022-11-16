package com.ceyentra.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Practice2SpringApp {
    public static void main(String[] args) {
        // loaad the spring configuration file
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("applicationContext.xml");

        // retrieve bean from spring container
        Coach theCoach = context.getBean("myGolfCoach", GolfCoach.class);

        // call methods on the bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());

        // close the context
        context.close();
    }
}
