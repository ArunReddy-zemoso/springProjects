package com.aopdemo.aspect;

import com.aopdemo.Account;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import org.aspectj.lang.JoinPoint;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @After("execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint){
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=========>>>>> Executing @After(finally) on method: "+method);
    }

    @AfterThrowing(pointcut="execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))",throwing="exc")
    public void afterThrowingFinfAccountAdvice(JoinPoint joinPoint, Throwable exc) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=========>>>>> Executing @AfterThrowing on method: "+method);
        System.out.println("\n=========>>>>> Exception: "+exc);
    }

    @AfterReturning(pointcut="execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))",returning="result")
    public void afterReturingFindAccountAdvice(JoinPoint joinPoint, List<Account> result){
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=========>>>>> Executing @AfterReturning on method: "+method);

        convertAccountNamesToUpperCase(result);
        System.out.println("\n=========>>>>> result: "+result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for(Account account : result) {
            String upperName = account.getName().toUpperCase();
            account.setName(upperName);
        }
    }

    @Before("com.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvide(JoinPoint joinPoint){
        System.out.println("\n=====>>> Executing @Before advice on method");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method: "+methodSignature);

        Object[] args= joinPoint.getArgs();

        for(Object arg : args){
            System.out.println(arg);
            if(arg instanceof Account){
                Account account = (Account) arg;
                System.out.println("account name: "+account.getName());
                System.out.println("account level: "+account.getLevel());
            }
        }
    }

}
