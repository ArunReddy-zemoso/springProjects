package com.aopdemo.dao;

import com.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
    private String name;
    private String eserviceCode;

    public void addAccount(Account account, boolean vipFlag){
        System.out.println(getClass()+": Doing my work: adding account");
    }
    public boolean doWork(){
        System.out.println(getClass()+": dowork()");
        return false;
    }

    public String getName() {
        System.out.println(getClass()+": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+": setName()");
        this.name = name;
    }

    public String getEserviceCode() {
        System.out.println(getClass()+": in getService()");
        return eserviceCode;
    }

    public void setEserviceCode(String eserviceCode) {
        System.out.println(getClass()+": in setService()");
        this.eserviceCode = eserviceCode;
    }
}
