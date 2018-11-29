package com.cdac.test;

import org.junit.Test;

import com.cdac.dao.GenericDao;
import com.cdac.entity.Address;
import com.cdac.entity.Person;

public class TestPerson {

	@Test
	public void addPersonAlongWithAddress() {
		Person p = new Person();
		p.setName("Majrul");
		p.setAge(99);
		p.setOccupation("Consultant");
		
		Address a = new Address();
		a.setCity("Mumbai");
		a.setState("MH");
		a.setPincode(400083);
		
		a.setPerson(p);
		p.setAddress(a);

		GenericDao dao = new GenericDao();
		dao.save(p);
		//dao.save(a);
	}

	@Test
	public void addPerson() {
		Person p = new Person();
		p.setName("John");
		p.setAge(99);
		p.setOccupation("Consultant");
		
		GenericDao dao = new GenericDao();
		dao.save(p);
	}
	
	@Test
	public void addAddress() {
		GenericDao dao = new GenericDao();
		Person p = dao.fetch(Person.class, 18);//john
		
		Address a = new Address();
		a.setCity("Delhi");
		a.setState("DL");
		a.setPincode(410083);
		a.setPerson(p);
		
		dao.save(a);
	}

	@Test
	public void fetch() {
		GenericDao dao = new GenericDao();
		
		Person p = dao.fetch(Person.class, 16);
		System.out.println(p.getName());
		System.out.println(p.getAge());
		System.out.println(p.getOccupation());
		
		Address a = p.getAddress();
		System.out.println(a.getCity());
		System.out.println(a.getState());
		System.out.println(a.getPincode());
	}
	
	
}










