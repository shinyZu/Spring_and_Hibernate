package com.ceyentra.aopdemo;

import com.ceyentra.aopdemo.config.DemoConfig;
import com.ceyentra.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundHandleExceptionDemoApp {

    // get the fully qualified name of the class
    private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        TrafficFortuneService theFortuneService
                = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        myLogger.info("\n>>> Main Program AroundHandleExceptionDemoApp");

        myLogger.info(">>> Calling getFortune()");

        boolean tripWire = true;
        String data = theFortuneService.getFortune(tripWire);

        myLogger.info("\nMy Fortune is: " + data);
        myLogger.info("Finished!");

        // close the context
        context.close();
    }
}
