package com.ceyentra.hibernate.demo;

import com.ceyentra.hibernate.demo.entity.Course;
import com.ceyentra.hibernate.demo.entity.Instructor;
import com.ceyentra.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {
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

            /** Option 2: Hibernate Query with HQL */

            // get the instructor from db
            int theID = 1;
            Query<Instructor> query = session.createQuery("select i from Instructor i JOIN FETCH  i.courses where i.id=:theInstructorId",
                    Instructor.class);

            // set parameter on query
            query.setParameter("theInstructorId", theID);

            // execute query and get instructor
            Instructor tempInstructor = query.getSingleResult();

            System.out.println("\n>> luv2code Instructor: " +tempInstructor);

            // commit the transaction
            session.getTransaction().commit();

            // close the session
            session.close();

            // since courses are to be lazy loaded this should fail when session closed
            System.out.println("\nThe session is now closed!\n");

            // get courses for the instructor
            // session is closed..will it FAIL????? Nooooo
            System.out.println(">> luv2code Courses: " +tempInstructor.getCourses());
            System.out.println();

            System.out.println(">> luv2code Done....!");

        } finally {
            factory.close();
        }
    }
}
