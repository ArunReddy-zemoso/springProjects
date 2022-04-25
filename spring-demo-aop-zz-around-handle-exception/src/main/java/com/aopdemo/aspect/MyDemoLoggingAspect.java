package com.aopdemo.aspect;

import com.aopdemo.Account;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import org.aspectj.lang.JoinPoint;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    private Logger logger=Logger.getLogger(getClass().getName());

    @After("execution(* com.aopdemo.service.*.getFortune(..))")
    public void afterCheck(){
       logger.info("After");
    }

    @Before("execution(* com.aopdemo.service.*.getFortune(..))")
    public void beforeCheck(){
        logger.info("Before");
    }

    @AfterThrowing("execution(* com.aopdemo.service.*.getFortune(..))")
    public void afterThrowingCheck(){
        logger.info("After throwing");
    }

    @AfterReturning("execution(* com.aopdemo.service.*.getFortune(..))")
    public void afterReturningCheck(){
        logger.info("After returning");
    }

    @Around("execution(* com.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        String method = proceedingJoinPoint.getSignature().toShortString();
        logger.info("\n=========>>>>> Executing @Around on method: "+method);

        long begin=System.currentTimeMillis();

        Object result =null;
        try {
            result = proceedingJoinPoint.proceed();
        }catch (Exception e){
            logger.warning(e.getMessage());

            result = "Major accident! But no worries";
            //throw e;
        }

        long end=System.currentTimeMillis();

        long duration=end-begin;

        logger.info("\n=======> Duration: "+duration/1000.0 +" seconds");

        return result;
    }

//    @After("execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))")
//    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint){
//        String method = joinPoint.getSignature().toShortString();
//        logger.info("\n=========>>>>> Executing @After(finally) on method: "+method);
//    }
//
//    @AfterThrowing(pointcut="execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))",throwing="exc")
//    public void afterThrowingFinfAccountAdvice(JoinPoint joinPoint, Throwable exc) {
//        String method = joinPoint.getSignature().toShortString();
//        logger.info("\n=========>>>>> Executing @AfterThrowing on method: "+method);
//        logger.info("\n=========>>>>> Exception: "+exc);
//    }
//
//    @AfterReturning(pointcut="execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))",returning="result")
//    public void afterReturingFindAccountAdvice(JoinPoint joinPoint, List<Account> result){
//        String method = joinPoint.getSignature().toShortString();
//        logger.info("\n=========>>>>> Executing @AfterReturning on method: "+method);
//
//        convertAccountNamesToUpperCase(result);
//        logger.info("\n=========>>>>> result: "+result);
//
//    }
//
//    private void convertAccountNamesToUpperCase(List<Account> result) {
//        for(Account account : result) {
//            String upperName = account.getName().toUpperCase();
//            account.setName(upperName);
//        }
//    }
//
//    @Before("com.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
//    public void beforeAddAccountAdvide(JoinPoint joinPoint){
//        logger.info("\n=====>>> Executing @Before advice on method");
//
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//
//        logger.info("Method: "+methodSignature);
//
//        Object[] args= joinPoint.getArgs();
//
//        for(Object arg : args){
//            logger.info(arg.toString());
//            if(arg instanceof Account){
//                Account account = (Account) arg;
//                logger.info("account name: "+account.getName());
//                logger.info("account level: "+account.getLevel());
//            }
//        }
//    }

}
