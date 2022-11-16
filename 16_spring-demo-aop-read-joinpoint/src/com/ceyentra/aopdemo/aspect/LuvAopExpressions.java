package com.ceyentra.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/** A Utility class -to share with other classes*/
@Aspect
public class LuvAopExpressions {
    // create pointcut for package
    @Pointcut("execution(* com.ceyentra.aopdemo.dao.*.*(..))")
    public void forDaoPackage(){}

    // create pointcut for getter methods
    @Pointcut("execution(* com.ceyentra.aopdemo.dao.*.get*(..))")
    public void getter(){}

    // create pointcut for setter methods
    @Pointcut("execution(* com.ceyentra.aopdemo.dao.*.set*(..))")
    public void setter(){}

    // create pointcut: include package... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter(){}
}
