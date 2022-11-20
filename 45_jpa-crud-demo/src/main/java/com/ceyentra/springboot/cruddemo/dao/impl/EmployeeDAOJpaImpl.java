package com.ceyentra.springboot.cruddemo.dao.impl;

import com.ceyentra.springboot.cruddemo.dao.EmployeeDAO;
import com.ceyentra.springboot.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> findAll() {
        // create a query
        Query query = entityManager.createQuery("from Employee");

        // execute query and get result list
        List<Employee> employees = query.getResultList();

        // return the results
        return employees;
    }

    @Override
    public Employee findById(int id) {
        // get the employee
        Employee employee = entityManager.find(Employee.class, id);

        // return the employee
        return employee;
    }

    @Override
    public void save(Employee employee) {
        // save employee
        Employee dbEmployee = entityManager.merge(employee);

        // update with id from db... so we can get generated id for save/insert
        employee.setId(dbEmployee.getId());

    }

    @Override
    public void deleteById(int id) {
        // delete object with PK
        Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
