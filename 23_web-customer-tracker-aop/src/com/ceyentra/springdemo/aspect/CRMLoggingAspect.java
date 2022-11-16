package com.ceyentra.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    // setup logger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    // setup pointcut declarations
    @Pointcut("execution(* com.ceyentra.springdemo.controller.*.*(..))")
    public void forControllerPackage(){

    }

    @Pointcut("execution(* com.ceyentra.springdemo.service.*.*(..))")
    public void forServicePackage(){}

    @Pointcut("execution(* com.ceyentra.springdemo.dao.*.*(..))")
    public void forDaoPackage(){}

    // combine pointcuts to match are desired methods
    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    public void forAppFlow(){}

    // add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint){

        // display the methods we are calling
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("====>> in @Before: calling method: " + theMethod);

        // display the arguments to the method
        // 1. get the arguments
        Object[] args = theJoinPoint.getArgs();

        // 2. loop through & display args
        for (Object tempArg : args) {
            myLogger.info(">>> argument: " + tempArg);
        }
    }

    // add @AfterReturning advice
    @AfterReturning(pointcut = "forAppFlow()", returning = "theResult")
    public void afterReturning(JoinPoint theJoinPoint, Object theResult){

        // display the methods we are calling
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("====>> in @AfterReturning: calling method: " + theMethod);

        // display the data returned
        myLogger.info("=====>>> result is : " + theResult);
    }

}
