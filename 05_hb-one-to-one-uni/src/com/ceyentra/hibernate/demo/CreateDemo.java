package com.ceyentra.hibernate.demo;

import com.ceyentra.hibernate.demo.entity.Instructor;
import com.ceyentra.hibernate.demo.entity.InstructorDetail;
import com.ceyentra.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try{
            // create the objects
            Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "Guitar");

            // associate the objects together
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            // start a transaction
            session.beginTransaction();

            //  save the instructor
            /* Note: This will also save the details object bcz of CascadeType.ALL
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
