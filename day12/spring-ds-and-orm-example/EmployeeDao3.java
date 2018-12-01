package com.cdac.component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component("empDao3")
public class EmployeeDao3 {

	@Autowired
	private DataSource dataSource;
	
	public void insert(int empno, String name, double salary) {
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		jt.update("insert into TBL_EMP values(?,?,?)", empno, name, salary);
	}
	
	public List<Employee> fetchAll() {
		JdbcTemplate jt = new JdbcTemplate();
		List<Employee> list = jt.query("select * from TBL_EMP", new EmpRowMapper());
		return list;
	}
	
	class EmpRowMapper implements RowMapper<Employee> {
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee emp = new Employee();
			emp.setEmpno(rs.getInt(1));
			emp.setName(rs.getString(2));
			emp.setSalary(rs.getDouble(3));
			return emp;
		}
	}
}
