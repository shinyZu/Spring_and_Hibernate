package com.ceyentra.springdemo.beans;

import com.ceyentra.springdemo.interfaces.FortuneService;
import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return null;
    }
}
