package com.ceyentra.aopdemo;

import com.ceyentra.aopdemo.config.DemoConfig;
import com.ceyentra.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundWithLoggerDemoApp {

    // get the fully qualified name of the class
    private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        TrafficFortuneService theFortuneService
                = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        myLogger.info("\n>>> Main Program AroundWithLoggerDemoApp");

        myLogger.info(">>> Calling getFortune()");
        String data = theFortuneService.getFortune();

        myLogger.info("\nMy Fortune is: " + data);
        myLogger.info("Finished!");

        // close the context
        context.close();
    }
}
