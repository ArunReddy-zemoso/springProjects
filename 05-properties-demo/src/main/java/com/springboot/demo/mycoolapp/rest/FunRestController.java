package com.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/teaminfo")
    public String getTeaminfo() {
        return "Coach: "+ coachName + ", Team name: "+teamName;
    }

    @GetMapping("/")
    public String sayHello(){
        return "Hello World! "+ LocalDateTime.now();
    }

    @GetMapping("/workout")
    public  String getDetailWorkout(){ return "run a hard 5K!"; }

    @GetMapping("/fortune")
    public  String getDetailFortunes(){ return "today is lucky da"; }
}
