package com.springdemo;

public class BaseballCoach implements Coach{

    private FortuneService fortuneService;

    BaseballCoach(HappyFortuneService fortuneService){
        this.fortuneService=fortuneService;
    }

    @Override
    public String getDailyWorkout(){
        return "spend 30 minutes on batting practice";
    }

    @Override
    public String getDailyFortune(){
        return  fortuneService.getFortune();
    }
}
