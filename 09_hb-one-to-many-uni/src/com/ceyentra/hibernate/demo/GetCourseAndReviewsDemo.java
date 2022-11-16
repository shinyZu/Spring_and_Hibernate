package com.ceyentra.hibernate.demo;

import com.ceyentra.hibernate.demo.entity.Course;
import com.ceyentra.hibernate.demo.entity.Instructor;
import com.ceyentra.hibernate.demo.entity.InstructorDetail;
import com.ceyentra.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseAndReviewsDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try{
            // start a transaction
            session.beginTransaction();

            // get the course
            int theId  = 10;
            Course tempCourse = session.get(Course.class, theId);

            // print the course
            System.out.println("\n>> tempCourse: " + tempCourse);
            System.out.println();

            // print the course reviews
            System.out.println("\n>> reviews: "+tempCourse.getReviews());
            System.out.println();

            // commit the transaction
            session.getTransaction().commit();

            System.out.println(">> Done....!");

        } finally {
            factory.close();
        }
    }
}
