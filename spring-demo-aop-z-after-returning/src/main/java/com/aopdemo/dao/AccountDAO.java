package com.aopdemo.dao;

import com.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {
    private String name;
    private String eserviceCode;

    public List<Account> findAccounts(){
        List<Account> accounts = new ArrayList<Account>();

        Account account1= new Account("John", "silver");
        Account account2= new Account("Madhu", "Platinum");
        Account account3= new Account("Luca", "Gold");

        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);

        return accounts;
    }

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
