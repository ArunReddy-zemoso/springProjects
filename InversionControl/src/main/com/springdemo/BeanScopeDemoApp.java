package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
    public static void main(String[] args) {
        //load spring config file
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("resources/beanScope-applicationContext.xml");


        //retrive bean from spring container
        Coach coach=context.getBean("myCoach",Coach.class);
        Coach alphaCoach=context.getBean("myCoach",Coach.class);

        boolean result=coach==alphaCoach;
        System.out.println(result);

        context.close();
    }
}
