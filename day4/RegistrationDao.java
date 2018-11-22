package com.cdac.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cdac.exception.DataAccessException;
import com.cdac.form.RegistrationForm;

//Data Access Object - 
//common naming convention for classes in which we write database code 
public class RegistrationDao {

	public void insert(RegistrationForm form) throws DataAccessException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			//TODO : Please copy mysql-connector-5.x.x.jar to WEB-INF\lib folder
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			stmt = conn.prepareStatement("insert into TBL_REGISTER values(?,?,?,?,?,?)");
			stmt.setString(1, form.getName());
			stmt.setString(2, form.getEmail());
			stmt.setString(3, form.getCity());
			stmt.setInt(4, form.getPincode());
			stmt.setString(5, form.getUsername());
			stmt.setString(6, form.getPassword());
			stmt.executeUpdate(); //DML			
		}
		catch(SQLException e) {
			//e.printStackTrace();
			throw new DataAccessException("problem while inserting data in TBL_customer table", e);
		}
		finally {
			try { stmt.close(); } catch(Exception e) { }
			try { conn.close(); } catch(Exception e) { }
		}
	}
}
