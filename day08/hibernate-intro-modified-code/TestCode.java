package com.cdac.test;

import org.junit.Test;

import com.cdac.dao.CustomerDao;
import com.cdac.entity.Customer;

public class TestCode {
	

	@Test
	public void addCustomer() {
		Customer customer = new Customer();
		//customer.setId(5);
		customer.setName("John");
		customer.setEmail("john@gmail.com");
		
		CustomerDao dao = new CustomerDao();
		dao.add(customer);
	}
	
	@Test
	public void fetchCustomer() {
		CustomerDao dao = new CustomerDao();
		Customer c = dao.fetch(3);
		System.out.println(c.getId() + " , " + c.getName() + " , " + c.getEmail());
	}
	
	//public static void main(String[] args) {
		/*Customer customer = new Customer();
		//customer.setId(5);
		customer.setName("Majrul");
		customer.setEmail("majrul@gmail.com");
		
		CustomerDao dao = new CustomerDao();
		dao.add(customer);*/
		
		/*CustomerDao dao = new CustomerDao();
		Customer c = dao.fetch(3);
		System.out.println(c.getId() + " , " + c.getName() + " , " + c.getEmail());*/
	//}
}
