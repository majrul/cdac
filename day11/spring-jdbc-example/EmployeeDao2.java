package com.cdac.component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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
}
