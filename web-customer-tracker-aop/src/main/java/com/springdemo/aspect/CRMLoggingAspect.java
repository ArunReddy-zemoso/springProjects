package com.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.springdemo.controller.*.*(..))")
    private  void forControllerPackage(){}

    @Pointcut("execution(* com.springdemo.service.*.*(..))")
    private  void forServivePackage(){}

    @Pointcut("execution(* com.springdemo.dao.*.*(..))")
    private  void forDaoPackage(){}

    @Pointcut("forControllerPackage() || forServivePackage() || forDaoPackage() ")
    private void forAppFlow(){}

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint){
        String method = joinPoint.getSignature().toShortString();
        logger.info("====>> in @Before: calling method: "+method);

        Object[] args = joinPoint.getArgs();

        //System.out.println(args.length);
        for(Object arg : args){
            logger.info("====> argument: "+arg);
        }
    }

    @AfterReturning(
            pointcut="forAppFlow()",
            returning="result"
    )
    public  void  afterReturning(JoinPoint joinPoint,Object result){
        String method = joinPoint.getSignature().toShortString();
        logger.info("====>> in @AfterReturning: from method: "+method);

        logger.info("====>> result: "+result);

    }

}
