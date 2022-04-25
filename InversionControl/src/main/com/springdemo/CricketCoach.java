package com.springdemo;

public class CricketCoach implements Coach{

    private FortuneService fortuneService;

    private  String email;
    private  String team;

    public void setEmail(String email) {
        System.out.println("inside setter of CricketCoach-email");
        this.email = email;
    }

    public void setTeam(String team) {
        System.out.println("inside setter of CricketCoach-team");
        this.team = team;
    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }

    public CricketCoach(){
        System.out.println("inside constructor of CricketCoach");
    }

    public void setFortuneService(FortuneService fortuneService){
        System.out.println("inside setter of CricketCoach");
        this.fortuneService=fortuneService;
    }

    @Override
    public String getDailyWorkout(){
        return "Practice 30 minutes of batting";
    }

    @Override
    public String getDailyFortune(){
        return  fortuneService.getFortune();
    }
}
