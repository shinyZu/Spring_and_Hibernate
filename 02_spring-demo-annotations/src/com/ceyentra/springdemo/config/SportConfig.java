package com.ceyentra.springdemo.config;

import com.ceyentra.springdemo.beans.HappyFortuneService;
import com.ceyentra.springdemo.beans.SadFortuneService;
import com.ceyentra.springdemo.beans.SwimCoach;
import com.ceyentra.springdemo.interfaces.Coach;
import com.ceyentra.springdemo.interfaces.FortuneService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.ceyentra.springdemo")
@PropertySource("classpath:myLogger.properties")
@PropertySource("classpath:sport.properties")
public class SportConfig {
    @Bean
    public MyLoggerConfig myLoggerConfig(@Value("${root.logger.level}") String rootLoggerLevel,
                                         @Value("${printed.logger.level}") String printedLoggerLevel) {

        MyLoggerConfig myLoggerConfig = new MyLoggerConfig(rootLoggerLevel, printedLoggerLevel);
        return myLoggerConfig;
    }

    // define bean for our sad fortune service
    @Bean
    public FortuneService sadFortuneService() {
        return new SadFortuneService();
    }

    // define bean for our swim coach AND inject dependency
    @Bean
    public Coach swimCoach() {
        SwimCoach mySwimCoach = new SwimCoach(sadFortuneService());
        return mySwimCoach;
    }
}
