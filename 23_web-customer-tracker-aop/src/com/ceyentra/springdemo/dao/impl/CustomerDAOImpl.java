package com.ceyentra.springdemo.dao.impl;

import com.ceyentra.springdemo.dao.CustomerDAO;
import com.ceyentra.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
//    @Transactional
    public List<Customer> getCustomers() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query, execute query & get result list
        // sort by last name
        List<Customer> customerList = currentSession
                .createQuery("from Customer order by lastName", Customer.class)
                .getResultList();

        // return the list
        return customerList;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save / update the customer
        // currentSession.save(theCustomer);
        currentSession.saveOrUpdate(theCustomer);
    }

    @Override
    public Customer getCustomer(int theId) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save the customer
        return currentSession.get(Customer.class, theId);
    }

    @Override
    public void deleteCustomer(int theId) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // delete the customer with primary key
        Query query = currentSession.createQuery("delete from Customer where id=:customerId");
        query.setParameter("customerId", theId).executeUpdate();
    }
}
