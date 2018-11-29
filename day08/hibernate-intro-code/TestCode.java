package com.cdac.test;

import com.cdac.dao.CustomerDao;
import com.cdac.entity.Customer;

public class TestCode {

	public static void main(String[] args) {
		Customer customer = new Customer();
		//customer.setId(5);
		customer.setName("Majrul");
		customer.setEmail("majrul@gmail.com");
		
		CustomerDao dao = new CustomerDao();
		dao.add(customer);
	}
}
