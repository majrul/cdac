package com.cdac.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.entity.Flight;

@Component
public class FlightDao {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void add(Flight flight) {
		em.persist(flight);
	}
}
