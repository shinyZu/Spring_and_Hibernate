package com.ceyentra.hibernate.demo;

import com.ceyentra.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try{
            // start a transaction
            Transaction transaction = session.beginTransaction();

            //---- query students
            // List<Student> theStudents1 = session.createQuery("from Student").list();
            List<Student> theStudents2 = session.createQuery("from Student").getResultList();

            // display the students
            /*System.out.println("\nUsing list()...\n");
            for (Student tempStudent : theStudents1) {
                System.out.println(tempStudent);
            }*/
            System.out.println("\nUsing getResultList()...\n");
            displayStudents(theStudents2);

            //---- query student: lastName = 'Doe'
            List<Student> theStudents3 = session.createQuery("from Student s where s.lastName='Doe'").getResultList();

            // display students
            System.out.println("\nStudents with last name : Doe");
            displayStudents(theStudents3);

            //---- query students: lastName = "Doe" OR firstName="Daffy"
            List<Student> theStudents4 = session.createQuery("from Student s where s.lastName='Doe'" +
                    " OR s.firstName='Daffy'").getResultList();

            // display students
            System.out.println("\nStudents with last name = Doe OR first name = Daffy");
            displayStudents(theStudents4);

            //---- query students: email = %gmail.com
            System.out.println("\nStudents with email ending with 'gmail.com'");
            List<Student> theStudents5 = session.createQuery("from Student s where s.email" +
                    " LIKE '%gmail.com'").getResultList();
            displayStudents(theStudents5);

            // commit the transaction
            session.getTransaction().commit();

            System.out.println(">> Done....!");

        } finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> theStudents) {
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }
}
