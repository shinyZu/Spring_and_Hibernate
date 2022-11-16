package com.ceyentra.hibernate.demo.practice;

import com.ceyentra.hibernate.demo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class ReadEmployeeDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        // create session
        Session session;

        try{
            // save employees
            /*Employee employee = new Employee("Tom", "Black", "Ceyentra");
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();*/

            // retrieve employees from PK
            /*session = factory.getCurrentSession();
            session.beginTransaction();
            Employee emp = (Employee) session.createQuery("from Employee where id = 1").uniqueResult();
            System.out.println("Employee of id 1 : " +  emp);
            session.getTransaction().commit();*/

            // get employees of a given company
            /*session = factory.getCurrentSession();
            session.beginTransaction();
            List<Employee> list = session.createQuery("from Employee where company = 'Ceyentra'").getResultList();
            System.out.println("Employee working at Ceyentra");
            for (Employee emp: list) {
                System.out.println(emp);
            }
            session.getTransaction().commit();*/

            // delete employee by given PK
            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee employee = session.get(Employee.class, 3);
            session.delete(employee);
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
