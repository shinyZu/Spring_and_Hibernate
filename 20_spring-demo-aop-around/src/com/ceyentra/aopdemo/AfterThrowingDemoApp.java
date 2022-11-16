package com.ceyentra.aopdemo;

import com.ceyentra.aopdemo.config.DemoConfig;
import com.ceyentra.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {
    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO theAccountDAO
                = context.getBean("accountDAO", AccountDAO.class);

        List<Account> theAccounts = null;
        try{
            // add a boolean flag to simulate exceptions
            boolean tripWire = true; // wire or string in a room where once hit it one will fall over
            theAccounts = theAccountDAO.findAccounts(tripWire);

        } catch (Exception ex) {
            System.out.println("\n>>> Main Program....caught an Exception: " + ex);
        }

        // display the accounts
        System.out.println("\n>>> Main Program: AfterThrowingDemoApp");
        System.out.println("------");
        System.out.println(theAccounts);
        System.out.println("------");

        // close the context
        context.close();
    }
}
