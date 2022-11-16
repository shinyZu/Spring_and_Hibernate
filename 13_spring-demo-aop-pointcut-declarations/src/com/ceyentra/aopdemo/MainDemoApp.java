package com.ceyentra.aopdemo;

import com.ceyentra.aopdemo.config.DemoConfig;
import com.ceyentra.aopdemo.dao.AccountDAO;
import com.ceyentra.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        // call the business method
        theAccountDAO.addAccount(new Account(), true);
        theMembershipDAO.addSillyMember();
        theAccountDAO.doWork();
        theMembershipDAO.gotToSleep();

        // do it again!
        // System.out.println("\n Let's call it again!\n");
        // theAccountDAO.addAccount();

        // close the context
        context.close();
    }
}
