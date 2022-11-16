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
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    // get the fully qualified name of the class
    private Logger myLogger = Logger.getLogger(getClass().getName());

    //  add a new advice for @Around on the () method
    @Around("execution(* com.ceyentra.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{

        // print out method we are advising on
        String method = theProceedingJoinPoint.getSignature().toShortString();
        myLogger.info("\n>>>>>>>>>>>>> Executing @Around on method: " +method);

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // now, let's execute the method
        Object result = null;

        try {
            result = theProceedingJoinPoint.proceed();

        } catch (Exception e) {
            // log the exception
            myLogger.warning(e.getMessage());

            // give the user a custom message
            // result = "Major accident! But no worries, your private AOP helicopter is on th way!";

            // rethrow exception
            throw e;
        }

        // get end timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end - begin;
        myLogger.info("\n>>>> Duration: " + duration / 1000.0 + " seconds");

        return result;
    }

    //  add a new advice for @After on the findAccounts() method
    @After("execution(* com.ceyentra.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint){
        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n>>>>>>>>>>>>> Executing @After(finally) on method: " +method);
    }

    // add a new advice for @AfterThrowing on the findAccounts() method
    @AfterThrowing(pointcut = "execution(* com.ceyentra.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc){

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n>>>>>>>>>>>>> Executing @AfterThrowing on method: " +method);

        // log the exception
         myLogger.info(">>> The Exception is: "+theExc);
    }

    // add a new advice for @AfterReturning on the findAccounts() method
    @AfterReturning(pointcut = "execution(* com.ceyentra.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result){

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n>>>>>>>>>>>>> Executing @AfterReturning on method: " +method);

        // print out the result of the method call
        myLogger.info("\n-----");
        myLogger.info(">>> result is: " +result);
        myLogger.info("-----");

        // post-process the data... modify it before reaching the caller
        // convert the account names to uppercase
        for (Account account : result) {
            account.setName(account.getName().toUpperCase());
        }
    }

    // add a new advice for @Before on the addAccount() method
    @Before("com.ceyentra.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        myLogger.info("======>>> Executing @Before advice on method");

        // display the method signature
        Signature signature = theJoinPoint.getSignature();
        MethodSignature methodSig = (MethodSignature) signature;
//        myLogger.info("signature: " + signature);
        myLogger.info("methodSig: " + methodSig);

        // display the method arguments
        Object[] args = theJoinPoint.getArgs();
        for (Object tempArg : args) {
            myLogger.info("arg: " + tempArg);

            if(tempArg instanceof Account){
                // downcast & print Account specific stuff
                Account theAccount = (Account) tempArg;
                myLogger.info("Account Name: " + theAccount.getName());
                myLogger.info("Account Level: " + theAccount.getLevel());
            }
        }


    }
}
