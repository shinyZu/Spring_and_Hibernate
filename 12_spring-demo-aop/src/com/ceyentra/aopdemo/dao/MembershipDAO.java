package com.ceyentra.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
    public boolean addSillyMember(){
        System.out.println(getClass() +
                ": DOING MY DB WORK: " +
                "adding a MembershipDAO Account" );
        return true;
    }

    public void gotToSleep(){
        System.out.println(getClass() + ": gotToSleep()" );
    }
}
