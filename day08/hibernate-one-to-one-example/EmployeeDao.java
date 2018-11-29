package com.cdac.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cdac.entity.Employee;

public class EmployeeDao {

	public void add(Employee emp) {
		//Step 1. Create EntityManagerFactory object
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("abc"); //reads META-INF/persistence.xml file
		//Step 2. Create EntityManager object
		EntityManager em = emf.createEntityManager();
		//Step 3. Start a transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//now we can insert/update/delete whatever we want
		em.persist(emp); //insert
		
		tx.commit();
		
		//TODO : Please put the below close statements in finally block
		em.close();
		emf.close();

	}
}
