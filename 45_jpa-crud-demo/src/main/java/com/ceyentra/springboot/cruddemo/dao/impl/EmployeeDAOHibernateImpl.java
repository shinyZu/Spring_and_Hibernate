package com.ceyentra.springboot.cruddemo.dao.impl;

import com.ceyentra.springboot.cruddemo.dao.EmployeeDAO;
import com.ceyentra.springboot.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    // define field for entityManager
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> findAll() {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<Employee> theQuery
                = currentSession.createQuery("from Employee", Employee.class);

        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        // return the results
        return employees;
    }

    @Override
    public Employee findById(int id) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // get the employee
        Employee employee = currentSession.get(Employee.class, id);

        // return the employee
        return employee;
    }

    @Override
    public void save(Employee employee) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // save employee
        currentSession.saveOrUpdate(employee);
    }

    @Override
    public void deleteById(int id) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // delete object with PK
        Query query = currentSession.createQuery("delete from Employee where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
