package com.aopdemo.dao;

import com.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
    public void addAccount(Account account, boolean vipFlag){
        System.out.println(getClass()+": Doing my work: adding account");
    }
    public boolean doWork(){
        System.out.println(getClass()+": dowork()");
        return false;
    }
}
