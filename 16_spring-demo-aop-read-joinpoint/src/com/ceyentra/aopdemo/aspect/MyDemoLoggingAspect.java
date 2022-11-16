package com.ceyentra.aopdemo.aspect;

import com.ceyentra.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    @Before("com.ceyentra.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("======>>> Executing @Before advice on method");

        // display the method signature
        Signature signature = theJoinPoint.getSignature();
        MethodSignature methodSig = (MethodSignature) signature;
        System.out.println("signature: " + signature);
        System.out.println("methodSig: " + methodSig);

        // display the method arguments
        Object[] args = theJoinPoint.getArgs();
        for (Object tempArg : args) {
            System.out.println("arg: " + tempArg);

            if(tempArg instanceof Account){
                // downcast & print Account specific stuff
                Account theAccount = (Account) tempArg;
                System.out.println("Account Name: " + theAccount.getName());
                System.out.println("Account Level: " + theAccount.getLevel());
            }
        }


    }
}
