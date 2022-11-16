package com.ceyentra.aopdemo.dao;

import com.ceyentra.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
    public void addAccount(Account theAccount, boolean vipFlag){
        System.out.println(getClass() +
                ": DOING MY DB WORK: " +
                "ADDING AN ACCOUNT in AccountDAO" );
    }

    public boolean doWork(){
        System.out.println(getClass() + ": doWork()" );
        return false;
    }
}

