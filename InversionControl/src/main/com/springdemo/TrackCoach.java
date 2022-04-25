package com.springdemo;

public class TrackCoach implements Coach{
    private FortuneService fortuneService;

    public TrackCoach(){}

    TrackCoach(FortuneService fortuneService){
        this.fortuneService=fortuneService;
    }

    @Override
    public String getDailyWorkout(){
        return "run hard 5k";
    }

    @Override
    public String getDailyFortune(){
        return "Track"+fortuneService.getFortune();
    }

    //add an init method
    public void doMyStartupStuff(){
        System.out.println("TrackCoach: inside doMyStartupStuff");
    }

    //add a destroy method
    public void doMyCleanupStuff(){
        System.out.println("TrackCoach: inside doMyCleanupStuff");
    }
}
