package com.ceyentra.aopdemo.dao;

import com.ceyentra.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {
    private String name;
    private String serviceCode;

    // add a new method: findAccounts()
    public List<Account> findAccounts(boolean tripWire){
        // for academic purpose....simulate an exception
        if (tripWire) {
            throw new RuntimeException("No soup for uuu!!!");
        }

        ArrayList<Account> myAccounts = new ArrayList<>();

        // create sample accounts
        Account temp1 = new Account("John", "Silver");
        Account temp2 = new Account("Madhu", "Platinum");
        Account temp3 = new Account("Luca", "Gold");

        // add tem to our accounts list
        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);
        return myAccounts;
    }

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

