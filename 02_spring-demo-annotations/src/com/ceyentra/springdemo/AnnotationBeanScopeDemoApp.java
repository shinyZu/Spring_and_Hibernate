package com.ceyentra.springdemo;

import com.ceyentra.springdemo.interfaces.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {
        /* load spring config file */
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("applicationContext.xml");

        /* retrieve bean fom spring container */
        Coach theCoach = context.getBean("tennisCoach", Coach.class);
        Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

        /* check if they are same */
        boolean result = (theCoach == alphaCoach);

        // print out the results
        System.out.println("Pointing to the same object : "+result); // false
        System.out.println(" Memory location for theCoach : "+theCoach); // TennisCoach@55a1c291
        System.out.println(" Memory location for alphaCoach : "+alphaCoach); // TennisCoach@2145433b

        /* close the context */
        context.close();
    }
}
