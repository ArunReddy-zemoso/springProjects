package com.aopdemo;

import com.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;


public class AroundHandleExceptionDemoApp {
    private static Logger logger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService fortuneService = context.getBean("trafficFortuneService",TrafficFortuneService.class);

        logger.info("\nMain Program: AroundHandleExceptionDemoApp");
        logger.info("Calling getFortune");

        boolean tripWired = false;
        String data = fortuneService.getFortune(tripWired);

        logger.info("\nMy fortune is: "+data);
        logger.info("Finished");

        context.close();

    }
}
