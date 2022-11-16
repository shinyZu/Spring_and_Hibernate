package com.ceyentra.hibernate.demo;

import com.ceyentra.hibernate.demo.entity.Instructor;
import com.ceyentra.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {
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

            // get the instructor detail object
            int theID = 3;
            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theID);

            // print the instructor detail
            System.out.println("tempInstructorDetail: "+tempInstructorDetail);

            // print the associated instructor
            System.out.println("\n>> the associated instructor: "+ tempInstructorDetail.getInstructor());

            // now let's delete the instructor detail-
            // will ALSO delete associated Instructor bcz Bi-directional
            System.out.println("\n>> Deleting tempInstructorDetail: "+ tempInstructorDetail);
            session.delete(tempInstructorDetail);

            // remove the associated object reference
            // break bi-directional link
            tempInstructorDetail.getInstructor().setInstructorDetail(null);

            // print instructor object
            Instructor tempInstructor = session.get(Instructor.class, 3);
            System.out.println("\n>> Instructor not deleted: "+ tempInstructor);

            // commit the transaction
            session.getTransaction().commit();

            System.out.println(">> Done....!");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            // handle connection leak issue
            session.close();
            factory.close();
        }
    }
}
