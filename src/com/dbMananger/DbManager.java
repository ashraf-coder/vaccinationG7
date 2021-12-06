package com.dbMananger;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.productManagement.Product;


public class DbManager {
	private String jdbcURL = "jdbc:mysql://localhost:3306/bse_assignment?useSSL=false";
	private String jdbcUsername = "root@localhost";
	private String jdbcPassword = "";
	private String jdbcDriver = "com.mysql.jdbc.Driver";


	private static final String SELECT_PRODUCT_BY_ID = "select id,vaccine_name from vaccines where id =?";
	private static final String SELECT_ALL_VACCINES = "select * from vaccines";
	

	public DbManager() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(jdbcDriver);
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public Product selectProduct(int id) {
		Product product = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				int price = rs.getInt("price");
				product = new Product(id, name, price);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return product;
	}

	public List<Product> selectAllProducts() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Product> products = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_VACCINES);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				products.add(new Product(id, name, price));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return products;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}