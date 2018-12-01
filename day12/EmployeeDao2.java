package com.cdac.component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("empDao2")
public class EmployeeDao2 {

	@Autowired
	private DataSource dataSource;
	
	public void insert(int empno, String name, double salary) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement("insert into TBL_EMP values(?,?,?)");
			pstmt.setInt(1, empno);
			pstmt.setString(2, name);
			pstmt.setDouble(3, salary);
			pstmt.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace(); //throw instead
		}
		finally {
			try { pstmt.close(); } catch(Exception e) { }
			try { conn.close(); } catch(Exception e) { }
		}
	}
	
	public List<Employee> fetchAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement("select * from TBL_EMP");
			rs = pstmt.executeQuery();
			List<Employee> list = new ArrayList<Employee>();
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmpno(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setSalary(rs.getDouble(3));
				list.add(emp);
			}
			return list;
		}
		catch (Exception e) {
			e.printStackTrace(); //throw instead
			return null;
		}
		finally {
			try { rs.close(); } catch(Exception e) { }
			try { pstmt.close(); } catch(Exception e) { }
			try { conn.close(); } catch(Exception e) { }
		}
	}
}
