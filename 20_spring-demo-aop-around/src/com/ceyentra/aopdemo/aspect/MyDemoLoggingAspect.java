package com.ceyentra.aopdemo.aspect;

import com.ceyentra.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    //  add a new advice for @Around on the () method
    @Around("execution(* com.ceyentra.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{

        // print out method we are advising on
        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n>>>>>>>>>>>>> Executing @Around on method: " +method);

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // now, let's execute the method
        Object result = theProceedingJoinPoint.proceed();

        // get end timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end - begin;
        System.out.println("\n>>>> Duration: " + duration / 1000.0 + " seconds");

        return result;
    }

    //  add a new advice for @After on the findAccounts() method
    @After("execution(* com.ceyentra.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint){
        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n>>>>>>>>>>>>> Executing @After(finally) on method: " +method);
    }

    // add a new advice for @AfterThrowing on the findAccounts() method
    @AfterThrowing(pointcut = "execution(* com.ceyentra.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc){

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n>>>>>>>>>>>>> Executing @AfterThrowing on method: " +method);

        // log the exception
         System.out.println(">>> The Exception is: "+theExc);
    }

    // add a new advice for @AfterReturning on the findAccounts() method
    @AfterReturning(pointcut = "execution(* com.ceyentra.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result){

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n>>>>>>>>>>>>> Executing @AfterReturning on method: " +method);

        // print out the result of the method call
        System.out.println("\n-----");
        System.out.println(">>> result is: " +result);
        System.out.println("-----");

        // post-process the data... modify it before reaching the caller
        // convert the account names to uppercase
        for (Account account : result) {
            account.setName(account.getName().toUpperCase());
        }
    }

    // add a new advice for @Before on the addAccount() method
    @Before("com.ceyentra.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("======>>> Executing @Before advice on method");

        // display the method signature
        Signature signature = theJoinPoint.getSignature();
        MethodSignature methodSig = (MethodSignature) signature;
//        System.out.println("signature: " + signature);
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
