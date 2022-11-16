package com.ceyentra.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Practice3SpringApp {
    public static void main(String[] args) {
        // load the spring configuration file
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        // retrieve bean from spring container
        Coach theCoach = context.getBean("myGolfCoach", GolfCoach.class);
        Coach alphaCoach = context.getBean("myGolfCoach", GolfCoach.class);

        // check if they are the same beans
        boolean result = (theCoach == alphaCoach);

        // print out the results
        System.out.println("Pointing to the same object : "+result); // false
        System.out.println(" Memory location for theCoach : "+theCoach); // GolfCoach@50b494a6
        System.out.println(" Memory location for alphaCoach : "+alphaCoach); // GolfCoach@3cef309d


        // close the context
        context.close();
    }

}
