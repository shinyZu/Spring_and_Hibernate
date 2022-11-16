package com.ceyentra.hibernate.demo;

import com.ceyentra.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try{
            // create a student object
            System.out.println(">> Creating a new student object..");
            Student tempStudent = new Student("Alex", "Willey", "alex@luv2code.com");

            // start a transaction
            Transaction transaction = session.beginTransaction();

            // save the student object
            System.out.println(">> Saving the student....");
            System.out.println(tempStudent);
            session.save(tempStudent);

            // commit the transaction
            session.getTransaction().commit();

            // MY NEW CODE

            // find out the student's id: PK
            System.out.println("Saved student. Generated id: " + tempStudent.getId());

            // now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve student based on the id: PK
            System.out.println("\nGetting student with id: "+tempStudent.getId());
            Student student = session.get(Student.class, tempStudent.getId());
            System.out.println("Get Complete: "+ student);

            // commit the transaction
            session.getTransaction().commit();

            System.out.println(">> Done....!");

        } finally {
            factory.close();
        }
    }
}
