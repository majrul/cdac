package com.cdac.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cdac.entity.Customer;

public class CustomerDao {

	public void add(Customer customer) {
		//Step 1. Create EntityManagerFactory object
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-proj");
		//Step 2. Create EntityManager object
		EntityManager em = emf.createEntityManager();
		//Step 3. Start a transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//now we can insert/update/delete whatever we want
		em.persist(customer); //insert
		
		tx.commit();
		
		//below code should be in finally block
		em.close();
		emf.close();
	}
}
