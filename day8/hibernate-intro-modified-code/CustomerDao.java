package com.cdac.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cdac.entity.Customer;

public class CustomerDao {

	public void add(Customer customer) {
		//Step 1. Create EntityManagerFactory object
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("abc"); //reads META-INF/persistence.xml file
		//Step 2. Create EntityManager object
		EntityManager em = emf.createEntityManager();
		//Step 3. Start a transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//now we can insert/update/delete whatever we want
		em.persist(customer); //insert
		
		tx.commit();
		
		//TODO : Please put the below close statements in finally block
		em.close();
		emf.close();
	}
	
	public Customer fetch(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("abc"); //reads META-INF/persistence.xml file
		EntityManager em = emf.createEntityManager();

		Customer c = em.find(Customer.class, id); //select

		//TODO : Please put the below close statements in finally block
		em.close();
		emf.close();

		return c;
	}
	
	//TODO : Write code to fetch all the customers from the database here
	public List<Customer> fetchAll() {
		
	}
}








