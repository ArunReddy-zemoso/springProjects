package com.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
    public boolean addSillyMember(){
        System.out.println(getClass()+" :DOING STUFF: ADDONG A MEMBERSHIP ACCOUNT");
        return true;
    }
    public void gotoSleep(){
        System.out.println(getClass()+" :I'm going to sleep now...");
    }
}
