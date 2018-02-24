package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
// Below is the version of query you need after Hibernate 5.2
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query...sort by last name
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", 
															  Customer.class);
		
		// execute query and get result list 
		List<Customer> customers = theQuery.getResultList();
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save the customer
		currentSession.save(theCustomer);
	}

}
