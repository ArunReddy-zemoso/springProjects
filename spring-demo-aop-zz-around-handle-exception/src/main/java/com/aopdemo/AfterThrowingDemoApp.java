package com.aopdemo;

import com.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDao=context.getBean("accountDAO",AccountDAO.class);

        List<Account> accounts=null;
        try {
            boolean tripWired=true;
            accounts = accountDao.findAccounts(true);
        }
        catch (Exception e) {
            System.out.println("\n\nMain Program ... caught exception: "+ e);
        }

        System.out.println("\n\nMain Program: AfterThrowingDemoApp");
        System.out.println("_____");

        System.out.println(accounts);

        System.out.println();

        context.close();

    }
}
