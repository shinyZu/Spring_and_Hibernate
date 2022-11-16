package com.ceyentra.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {
    @Before("com.ceyentra.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    private void logToCloudAsync() {
        System.out.println("======>>> Logging to cloud in async fashion");
    }
}
