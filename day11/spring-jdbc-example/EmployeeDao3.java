package com.cdac.component;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("empDao3")
public class EmployeeDao3 {

	@Autowired
	private DataSource dataSource;
	
	public void insert(int empno, String name, double salary) {
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		jt.update("insert into TBL_EMP values(?,?,?)", empno, name, salary);
	}
}
