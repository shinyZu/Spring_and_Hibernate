package com.ceyentra.hibernate.demo;

import com.ceyentra.hibernate.demo.entity.Course;
import com.ceyentra.hibernate.demo.entity.Instructor;
import com.ceyentra.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try{
            // create the objects
            Instructor tempInstructor = new Instructor("Susan", "Public", "susan.public@luv2code.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "Video Games");

            // associate the objects together
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            // start a transaction
            session.beginTransaction();

            //  save the instructor
            /* Note: This will also save the "details" object bcz of CascadeType.ALL
            * bcz it saves any associate object
            * */
            System.out.println(">> Saving Instructor: "+tempInstructor);
            session.save(tempInstructor);

            // commit the transaction
            session.getTransaction().commit();

            System.out.println(">> Done....!");

        } finally {
            factory.close();
        }
    }
}
