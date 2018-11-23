package com.cdac.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cdac.exception.DataAccessException;

public class ProductDao {

	//select * from TBL_PRODUCT limit 10,10
	
	public List<Product> loadDummyProducts(int position, int rows) {
		List<Product> products = new ArrayList<>();
		for(int i=1; i<=10000; i++) {
			Product product = new Product();
			product.setId(i);
			product.setName("Nokia "+i);
			product.setPrice(5000 + i);
			product.setQuantity(99);
			products.add(product);
		}

		return products.subList(position, position + rows);
	}
	
	
	public List<Product> fetchProducts(int position, int rows) throws DataAccessException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			stmt = conn.prepareStatement("select * from TBL_PRODUCT limit ?,?");
			stmt.setInt(1, position);
			stmt.setInt(2, rows);
			rs = stmt.executeQuery(); //select ..executeUpdate() for insert/update/delete
			
			List<Product> products = new ArrayList<>();
			while(rs.next()) { //fetching one row at a time from the table
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				product.setQuantity(rs.getInt("quantity"));
				products.add(product);
			}
			return products;
		}
		catch(Exception e) {
			throw new DataAccessException("unable to fetch products",e);
		}
		finally {
			try { rs.close(); } catch (Exception e) {}
			try { stmt.close(); } catch (Exception e) {}
			try { conn.close(); } catch (Exception e) {}
		}
	}
}
