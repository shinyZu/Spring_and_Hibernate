package com.ceyentra.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
    public static void main(String[] args) {
// loaad the spring configuration file
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        // retrieve bean from spring container
        Coach theCoach = context.getBean("myCoach", Coach.class);
        Coach alphaCoach = context.getBean("myCoach", Coach.class);

        // check if they are the same beans
        boolean result = (theCoach == alphaCoach);

        // print out the results
        System.out.println("Pointing to the same object : "+result); // false
        System.out.println(" Memory location for theCoach : "+theCoach); // TrackCoach@1dfe2924
        System.out.println(" Memory location for alphaCoach : "+alphaCoach); // TrackCoach@6ebc05a6

        // close the context
        context.close();
    }
}
