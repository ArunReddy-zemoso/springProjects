package com.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
//@Scope("prototype")
public class TennisCoach implements Coach{

    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    public TennisCoach(){
        System.out.println("tennisCoach: default constructor");
    }

    @PostConstruct
    public  void  doMyStartupStuff(){
        System.out.println("TennisCoach: inside of doMystartupstuff");
    }

    @PreDestroy
    public  void doMyCleanupStuff(){
        System.out.println("TennisCoach: inside of doMyCleanupStuff");
    }

//    public TennisCoach(FortuneService fortuneService){
//        this.fortuneService=fortuneService;
//    }
//    @Autowired
//    public  void setFortuneService(FortuneService fortuneService){
//        this.fortuneService=fortuneService;
//    }

//    @Autowired
//    public  void doSomeCrazy(FortuneService fortuneService){
//        System.out.println("TennisCoach: dosomecrazy");
//        this.fortuneService=fortuneService;
//    }

    @Override
    public String getDailyWorkout(){
        return "practice your backhand volley";
    }

    @Override
    public String getDailyFortune(){
        return fortuneService.getFortune();
    }

}
