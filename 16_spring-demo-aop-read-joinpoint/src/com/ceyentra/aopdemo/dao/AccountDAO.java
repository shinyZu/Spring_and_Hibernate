package com.ceyentra.aopdemo.dao;

import com.ceyentra.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
    private String name;
    private String serviceCode;

    public void addAccount(Account theAccount, boolean vipFlag){
        System.out.println(getClass() +
                ": DOING MY DB WORK: " +
                "ADDING AN ACCOUNT in AccountDAO\n" );
    }

    public boolean doWork(){
        System.out.println(getClass() + ": doWork()\n" );
        return false;
    }

    public String getName() {
        System.out.println(getClass() + ": getName()" );
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": setName()" );
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": getServiceCode()" );
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": setServiceCode()" );
        this.serviceCode = serviceCode;
    }
}
