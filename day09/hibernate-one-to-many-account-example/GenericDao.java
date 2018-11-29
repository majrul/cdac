package com.cdac.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cdac.entity.Customer;

public class GenericDao {

	public void save(Object obj) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("abc"); //reads META-INF/persistence.xml file
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.merge(obj); //insert or update
		
		tx.commit();
		
		//TODO : Please put the below close statements in finally block
		em.close();
		emf.close();
	}
	
	public <E> E fetch(Class<E> classname, int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("abc"); //reads META-INF/persistence.xml file
		EntityManager em = emf.createEntityManager();

		E e = em.find(classname, id); //select

		//TODO : Please put the below close statements in finally block
		em.close();
		emf.close();

		return e;
	}
	
	
}
