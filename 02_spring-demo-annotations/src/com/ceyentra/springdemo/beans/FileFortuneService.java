package com.ceyentra.springdemo.beans;

import com.ceyentra.springdemo.interfaces.FortuneService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//@Component
public class FileFortuneService implements FortuneService {
    private String fileName = "/home/shinyT480/Ceyentra/Projects/Udemy/02_spring-demo-annotations/src/com/ceyentra/springdemo/txt/fortune-data.txt";
    private List<String> theFortunes;

    // create a random number generator
    private Random myRandom = new Random();

    public FileFortuneService() {
        System.out.println(">> FileFortuneService: inside default constructor");
    }

    @PostConstruct
    private void loadTheFortunesFile() {
        System.out.println(">> Files will be load after bean constructed and DI...");
        File theFile = new File(fileName);
        System.out.println("Reading fortunes from file: " + theFile);
        System.out.println("File exists: " + theFile.exists());

        // initialize array list
        theFortunes = new ArrayList<String>();

        // read fortunes from file
        try {
            BufferedReader br = new BufferedReader(new FileReader(theFile));
            String tempLine;

            while ((tempLine = br.readLine()) != null) {
                theFortunes.add(tempLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String getFortune() {
        int index = myRandom.nextInt(theFortunes.size());
        String tempFortune = theFortunes.get(index);
        return tempFortune;
    }

    @PreDestroy
    public void doCleanupStuffYoYo(){
        System.out.println(">> FileFortuneService: inside method - doCleanupStuffYoYo");
    }
}
