package com.springdemo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService{
    private String[] data={
            "arun",
            "kumar",
            "reddy"
    };
    private Random random=new Random();



    @Override
    public  String getFortune(){

        int index;
        index = random.nextInt(data.length);

        String fortune=data[index];

        return fortune;
    }
}
