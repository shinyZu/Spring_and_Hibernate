package com.ceyentra.hibernate.demo;

import com.ceyentra.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try{
            int studentId = 1;

            // now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve student based on the id: PK
            System.out.println("\n>> Getting student with id: "+studentId);
            Student student = session.get(Student.class, studentId);

            System.out.println(">> Updating student....");
            student.setFirstName("Scooby"); // only update in the memory

            // commit the transaction
            session.getTransaction().commit();

            // Update email for all students
            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println(">> Update email for all students....");
            session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();

            // commit the transaction
            session.getTransaction().commit(); // once committed will be updated in the DB

            System.out.println(">> Done....!");

        } finally {
            factory.close();
        }
    }
}
