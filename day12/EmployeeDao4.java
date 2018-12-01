package com.cdac.component;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("empDao4")
public class EmployeeDao4 {

	//@Autowired - this annotation doesn't works for EntityManager object
	@PersistenceContext //there is no difference, we are injecting what we need
	private EntityManager em;
	
	@Transactional
	public void insert(Employee emp) {
		em.persist(emp);
	}
	
	public Employee fetch(int empno) {
		return em.find(Employee.class, empno);
	}
	
	public List<Employee> fetchAll() {
		Query q = em.createQuery("select emp from Employee emp");
		return q.getResultList();
	}
}
