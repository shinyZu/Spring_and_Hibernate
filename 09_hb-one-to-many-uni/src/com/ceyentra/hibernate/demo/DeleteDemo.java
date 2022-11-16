package com.ceyentra.hibernate.demo;

import com.ceyentra.hibernate.demo.entity.Instructor;
import com.ceyentra.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
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

            // start a transaction
            session.beginTransaction();

            // get instructor by PK/id
            int theID = 2;
            Instructor tempInstructor = session.get(Instructor.class, theID); // will return null if not found
            System.out.println(">> Found Instructor: "+tempInstructor);

            // delete the instructors
            if (tempInstructor != null) {
                System.out.println(">> Deleting Instructor..: "+ tempInstructor.getFirstName());

                /* will ALSO delete the associated "details" object bcz of CascadeType.ALL*/
                session.delete(tempInstructor);
            }

            // commit the transaction
            session.getTransaction().commit();

            System.out.println(">> Done....!");

        } finally {
            factory.close();
        }
    }
}
