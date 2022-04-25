package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("resources/applicationContext.xml");

        Coach coach=context.getBean("tennisCoach",Coach.class);

        Coach alphaCoach=context.getBean("tennisCoach",Coach.class);

        System.out.println(coach==alphaCoach);

        context.close();
    }
}
