package com.ceyentra.hibernate.demo;

import com.ceyentra.hibernate.demo.entity.Course;
import com.ceyentra.hibernate.demo.entity.Instructor;
import com.ceyentra.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {
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

            // create some courses
            Course course1 = new Course("Air Guitar - The Ultimate Guide");
            Course course2 = new Course("The Pinball Masterclass");

            // add courses to instructor
            tempInstructor.add(course1);
            tempInstructor.add(course2);

            // save the courses
            session.save(course1);
            session.save(course2);

            // commit the transaction
            session.getTransaction().commit();

            System.out.println(">> Done....!");

        } finally {
            factory.close();
        }
    }
}
