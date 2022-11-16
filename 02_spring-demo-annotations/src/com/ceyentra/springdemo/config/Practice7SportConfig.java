package com.ceyentra.springdemo.config;

import com.ceyentra.springdemo.beans.HappyFortuneService;
import com.ceyentra.springdemo.beans.WrestlingCoach;
import com.ceyentra.springdemo.interfaces.Coach;
import com.ceyentra.springdemo.interfaces.FortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:myLogger.properties")
public class Practice7SportConfig {
    // define bean for our happy fortune service
    @Bean
    public FortuneService happyFortuneService(){
        return new HappyFortuneService();
    }

    // define bean for our wrestling coach AND inject dependency
    @Bean
    public Coach wrestlingCoach(){
        return new WrestlingCoach(happyFortuneService());
    }

}
