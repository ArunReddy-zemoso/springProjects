package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    // this is where we add all of our related advices for logging

    //lets start with an @Before advice

    //@Before("execution(public void add*())")
    //@Before("execution(* add*(com.aopdemo.Account))")
    //@Before("execution(* add*(..))")

    @Pointcut("execution(* com.aopdemo.dao.*.*(..))")
    private void forDaoPackage(){}

    @Before("forDaoPackage()")
    public void beforeAddAccountAdvide(){
        System.out.println("\n=====>>> Executing @Before advice on method");
    }

    @Before("forDaoPackage()")
    public void performApiAnalysis(){
        System.out.println("\n=====>>> Performing API analytics @Before advice on method");
    }
}
