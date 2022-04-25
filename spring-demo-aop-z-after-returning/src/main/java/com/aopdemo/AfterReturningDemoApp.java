package com.aopdemo;

import com.aopdemo.dao.AccountDAO;
import com.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDao=context.getBean("accountDAO",AccountDAO.class);

        List<Account> accounts=accountDao.findAccounts();

        System.out.println("\n\nMain Program: AfterReturningDemoApp");
        System.out.println("_____");

        System.out.println(accounts);

        System.out.println();

        context.close();

    }
}
