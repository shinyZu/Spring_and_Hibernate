package com.ceyentra.hibernate.demo;

import com.ceyentra.hibernate.demo.entity.Course;
import com.ceyentra.hibernate.demo.entity.Instructor;
import com.ceyentra.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {
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
            // start a transaction
            session.beginTransaction();

            // get the instructor from db
            int theID = 1;
            Instructor tempInstructor = session.get(Instructor.class, theID);
            System.out.println("\n>> luv2code Instructor: " +tempInstructor);
            System.out.println();

            // session is still open..hence will lazy load
            System.out.println("\n>> luv2code Courses: " +tempInstructor.getCourses());

            // commit the transaction
            session.getTransaction().commit();

            // close the session
            session.close();

            // since courses are to be lazy loaded this should fail

            // get courses for the instructor
            // session is closed..will it FAIL????? NOOOOOOOOO
            System.out.println("\n>> luv2code Courses: " +tempInstructor.getCourses());
            System.out.println();

            System.out.println(">> luv2code Done....!");

        } finally {
            factory.close();
        }
    }
}
