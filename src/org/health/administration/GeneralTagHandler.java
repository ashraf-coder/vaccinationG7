package org.health.administration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;



public class GeneralTagHandler extends TagSupport {
	private static String table;  
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/vaccination_db?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    
	public void setTable(String table) {  
	    this.table = table;  
	} 
	
	
	public int doStartTag() throws JspException {
		if (table == "vaccines") {
			Connection connection = null;
			
		    JspWriter out=pageContext.getOut();//returns the instance of JspWriter  
		    try {

				 // Load the database driver

				  Class.forName(jdbcDriver);

				  // Get a Connection to the database

				  connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword); 

				  //Select the data from the database

				  String sql = "SELECT * FROM "+table;

				  Statement s = connection.createStatement();

				  s.executeQuery (sql);

				  ResultSet  rs = s.getResultSet();
				   
				  while (rs.next()) {  
	                 String name = rs.getString("name");    
	                 out.println("<option value = "+ rs.getInt("vaccine_id") +">" + name + "</option>");   
	         	  }  
		          
				  rs.close ();
			
				  s.close ();

			}catch(Exception e){

				System.out.println("Exception is ;"+e);

			}
		}
		
		if (table == "health_centers") {
			Connection connection = null;
			
		    JspWriter out=pageContext.getOut();//returns the instance of JspWriter  
		    try {

				 // Load the database driver

				  Class.forName(jdbcDriver);

				  // Get a Connection to the database

				  connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword); 

				  //Select the data from the database

				  String sql = "SELECT * FROM "+table;

				  Statement s = connection.createStatement();

				  s.executeQuery (sql);

				  ResultSet  rs = s.getResultSet();
				   
				  while (rs.next()) {  
	                 String name = rs.getString("name");    
	                 out.println("<option value = "+ rs.getInt("center_id") +">" + name + "</option>");   
	         	  }  
		          
				  rs.close ();
			
				  s.close ();

			}catch(Exception e){

				System.out.println("Exception is ;"+e);

			}
		}
		
		if (table == "patients") {
			Connection connection = null;
			int total_population = 4000; //assumed total population in uganda
			
		    JspWriter out=pageContext.getOut();//returns the instance of JspWriter  
		    try {

				 // Load the database driver

				  Class.forName(jdbcDriver);

				  // Get a Connection to the database

				  connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword); 
				  
				  String sql1 = "SELECT * FROM "+table;

				  Statement s1 = connection.createStatement();

				  s1.executeQuery (sql1);

				  ResultSet  rs1 = s1.getResultSet();
				  
				  float no_to_hit;
				  float sum = 0;
				  while (rs1.next()) {  
					 sum = sum + 1; 
				  }
				  no_to_hit = (sum/total_population)*100;
				  
				  //Select the data from the database

				  String sql = "SELECT * FROM "+table;

				  Statement s = connection.createStatement();

				  s.executeQuery (sql);

				  ResultSet  rs = s.getResultSet();
				  out.println("<h1>The percentage so far vaccinated = "+ no_to_hit + "%</h1>");
				  out.println("<table border=1 >");  
		             out.println("<tr><th>Email</th><th>NIN</th><th>NAME</th><th>Date Of Administration</th><th>Batch Number</th><th>View Patient Certificate</th><tr>");  
		             while (rs.next()) {  
		                 String email = rs.getString("email"); 
		                 String nin = rs.getString("nin"); 
		                 String name = rs.getString("name"); 
		                 String doa = rs.getString("doa"); 
		                 int batch_no = rs.getInt("batch_no");
		                 out.println("<tr><td>" + email + "</td><td>" + nin + "</td><td>" + name + "</td><td>" + doa + "</td><td>" + batch_no + "</td><td>"
		                 		+ "<form action='patient_certificate' method='POST'><input style='display:none' type='text' name='nin' value="+ nin +">"
		                 				+ "<input type='submit' value='view certificate'>"
		                 		+ "</form></td></tr>");   
		             }  
		          out.println("</table>"); 
		          
				  rs.close ();
			
				  s.close ();

			}catch(Exception e){

				System.out.println("Exception is ;"+e);

			}
		}
	    
	    return SKIP_BODY;//will not evaluate the body content of the tag  
	}  
}
