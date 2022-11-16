package com.ceyentra.aopdemo;

import com.ceyentra.aopdemo.config.DemoConfig;
import com.ceyentra.aopdemo.dao.AccountDAO;
import com.ceyentra.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {
    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO theAccountDAO
                = context.getBean("accountDAO", AccountDAO.class);

        // call method to find the accounts
        List<Account> theAccounts = theAccountDAO.findAccounts();

        // display the accounts
        System.out.println("\n>>> Main Program: AfterReturningDemoApp");
        System.out.println("------");
        System.out.println(theAccounts);
        System.out.println("------");

        // close the context
        context.close();
    }
}
