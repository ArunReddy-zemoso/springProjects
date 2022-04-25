package com.aopdemo;

import com.aopdemo.dao.AccountDAO;
import com.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDao=context.getBean("accountDAO",AccountDAO.class);
        MembershipDAO membershipDAO=context.getBean("membershipDAO",MembershipDAO.class);

        Account account = new Account();
        accountDao.addAccount(account,true);
        accountDao.doWork();


        accountDao.setName("foobar");
        accountDao.setEserviceCode("silver");

        String name=accountDao.getName();
        String code =accountDao.getEserviceCode();


        membershipDAO.addSillyMember();
        membershipDAO.gotoSleep();

        context.close();

    }
}
