package com.health.vaccine;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddVaccineServlet
 */

public class AddVaccineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String jdbcURL = "jdbc:mysql://localhost:3306/vaccination_db?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddVaccineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List dataList = new ArrayList();
		
		String name = request.getParameter("name");
		String number_of_doses = request.getParameter("number_of_doses");
		String number_of_shots = request.getParameter("number_of_shots");
		String period_btn_shots = request.getParameter("period_btn_shots");
		
		Connection connection = null;
		
		
		
		try {

		 // Load the database driver
			Class.forName(jdbcDriver);
	
			  // Get a Connection to the database
		
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword); 
		
			  //Select the data from the database
	
			String sql = "INSERT INTO vaccines" +
		            "  (name, no_of_doses, no_of_shots, period_btn_shots) VALUES " +
		            " (?, ?, ?, ?);";
		
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, number_of_doses);
            preparedStatement.setString(3, number_of_shots);
            preparedStatement.setString(4, period_btn_shots);
			
            int i = preparedStatement.executeUpdate();  
            if(i>0){
            	
  			  String site = "home" ; 
  			  response.setStatus(response.SC_MOVED_TEMPORARILY); 
  			  response.setHeader("Location", site);
            
            }
    	}
		catch(Exception e){

			System.out.println("Exception is ;"+e);

		}
	}

}
