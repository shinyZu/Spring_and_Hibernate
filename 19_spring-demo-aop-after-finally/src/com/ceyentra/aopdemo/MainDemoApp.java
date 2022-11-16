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
        theAccountDAO.addAccount(new Account("Madhu", "Platinum"), true);
        theMembershipDAO.addSillyMember();
        theAccountDAO.doWork();
        theMembershipDAO.gotToSleep();
        System.out.println();

        // call the accountDAO getters/setters
        theAccountDAO.setName("foobar");
        theAccountDAO.setServiceCode("silver");

        String name = theAccountDAO.getName();
        String serviceCode = theAccountDAO.getServiceCode();

        // close the context
        context.close();
    }
}
