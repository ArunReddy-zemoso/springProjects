package com.aopdemo;

import com.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;


public class AroundWithLoggerDemoApp {
    private static Logger logger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService fortuneService = context.getBean("trafficFortuneService",TrafficFortuneService.class);

        logger.info("\nMain Program: AroundWithLoggerDemoApp");
        logger.info("Calling getFortune");

        String data = fortuneService.getFortune(false);

        logger.info("\nMy fortune is: "+data);
        logger.info("FInished");

        context.close();

    }
}
