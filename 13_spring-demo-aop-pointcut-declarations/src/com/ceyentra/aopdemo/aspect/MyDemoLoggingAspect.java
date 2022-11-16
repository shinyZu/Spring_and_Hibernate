package com.ceyentra.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging
    // let's start with an @Before advice
    // declare a pointcut
    // apply the declared pointcut to advice

    @Pointcut("execution(* com.ceyentra.aopdemo.dao.*.*(..))")
    private void forDaoPackage(){}

    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n======>>> Executing @Before advice on " +
                "addAccount()");
    }

    @Before("forDaoPackage()")
    private void performApiAnalytics(){
        System.out.println("\n======>>> Performing API Analytics");
    }
}
