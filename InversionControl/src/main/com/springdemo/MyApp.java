package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
    public static void main(String[] args) {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("resources/applicationContext.xml");
            Coach coach = context.getBean("myCoach", Coach.class);

            System.out.println(coach.getDailyWorkout());
            System.out.println(coach.getDailyFortune());

            context.close();

    }
}
