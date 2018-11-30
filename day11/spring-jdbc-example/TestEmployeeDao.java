package com.cdac.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cdac.component.EmployeeDao;

public class TestEmployeeDao {

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("app-config.xml");
		EmployeeDao empDao = (EmployeeDao) context.getBean("empDao");
		empDao.insert(1001, "Majrul", 999999999);
	}
}
