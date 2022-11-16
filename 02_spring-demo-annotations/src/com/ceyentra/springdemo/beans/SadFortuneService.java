package com.ceyentra.springdemo.beans;

import com.ceyentra.springdemo.interfaces.FortuneService;

public class SadFortuneService implements FortuneService  {
    @Override
    public String getFortune() {
        return "Today is a sad day!";
    }
}
