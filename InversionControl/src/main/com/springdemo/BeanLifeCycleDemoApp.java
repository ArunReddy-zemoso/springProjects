package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {
    public static void main(String[] args) {
        //load spring config file
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("resources/beanLifeCycle-applicationContext.xml");


        //retrive bean from spring container
        Coach coach=context.getBean("myCoach",Coach.class);

        System.out.println(coach.getDailyWorkout());
        context.close();
    }
}
