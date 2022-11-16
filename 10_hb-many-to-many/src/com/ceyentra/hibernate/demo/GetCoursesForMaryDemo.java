package com.ceyentra.hibernate.demo;

import com.ceyentra.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCoursesForMaryDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try{
            // start a transaction
            session.beginTransaction();

            // get the student mary from database
            int theId=1;
            Student john = session.get(Student.class, theId);

            System.out.println("\n>> Loaded John: " + john);
            System.out.println("\n>> Courses: " + john.getCourses());

            // commit the transaction
            session.getTransaction().commit();

            System.out.println(">> Done....!");

        } finally {
            factory.close();
        }
    }
}
