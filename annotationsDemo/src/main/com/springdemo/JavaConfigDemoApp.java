package com.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContextExtensionsKt;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {
    public static void main(String[] args) {
        //read spring config file
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SportConfig.class);

        // get the bean from spring container
        Coach coach=context.getBean("tennisCoach",Coach.class);

        //call amethod on the bean
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());

        //close context
        context.close();
    }
}
