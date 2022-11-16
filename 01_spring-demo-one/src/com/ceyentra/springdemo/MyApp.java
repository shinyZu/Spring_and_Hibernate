package com.ceyentra.springdemo;

public class MyApp {

	public static void main(String[] args) {

		// create the object
		// com.ceyentra.springdemo.Coach theCoach = new com.ceyentra.springdemo.BaseballCoach();
		Coach theCoach = new TrackCoach();
		
		// use the object
		System.out.println(theCoach.getDailyWorkout());		
	}

}
