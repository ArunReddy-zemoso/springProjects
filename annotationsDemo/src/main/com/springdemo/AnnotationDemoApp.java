package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {
        //read spring config file
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("resources/applicationContext.xml");

        // get the bean from spring container
        Coach coach=context.getBean("tennisCoach",Coach.class);

        //call amethod on the bean
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());

        //close context
        context.close();
    }
}
