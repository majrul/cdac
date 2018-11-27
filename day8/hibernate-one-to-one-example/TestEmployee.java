package com.cdac.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.cdac.dao.EmployeeDao;
import com.cdac.entity.Employee;
import com.cdac.entity.EmployeeDetails;

public class TestEmployee {

	@Test
	public void addEmployee() throws Exception {
		Employee emp = new Employee();
		emp.setEmpno(1001);
		emp.setName("Majrul");
		emp.setDateOfBirth(new SimpleDateFormat("dd-MM-yyyy").parse("31-01-1981"));
		emp.setCity("Mumbai");
		
		EmployeeDetails empDetails = new EmployeeDetails();
		empDetails.setDateOfJoining(new Date());
		empDetails.setSalary(999999999);
		empDetails.setRole("Trainer");
		
		emp.setEmployeeDetails(empDetails);
		empDetails.setEmployee(emp);
		
		EmployeeDao dao = new EmployeeDao();
		dao.add(emp);
		
	}
}
