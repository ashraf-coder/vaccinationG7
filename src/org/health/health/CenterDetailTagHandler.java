package org.health.health;

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

public class CenterDetailTagHandler extends TagSupport {
	private static String table; 
	private static String where;
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/vaccination_db?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    
	public void setTable(String table) {  
	    this.table = table;  
	}
	
	public void setWhere(String where) {  
	    this.where = where;  
	}
	
	public int doStartTag() throws JspException {
			Connection connection = null;
			
		    JspWriter out=pageContext.getOut();//returns the instance of JspWriter  
		    try {

				 // Load the database driver

				  Class.forName(jdbcDriver);

				  // Get a Connection to the database

				  connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword); 

				  //Select the data from the database
				  String get_center_details = "SELECT * FROM "+ table +" where name = \""+ where +"\"";

				  Statement s = connection.createStatement();

				  s.executeQuery (get_center_details);

				  ResultSet  rs = s.getResultSet();
				  
				  while (rs.next()) { 
					  String name = rs.getString("name");
					  int id = rs.getInt("center_id");
					  String name_number = name + id;
					  int previous_month_patients_no = rs.getInt("previous_month_patients_no");
					  out.println("<div class='container text-center d-flex justify-content-center align-items-center' style='height: 100vh'>");
					  	out.println("<div>");
					  	out.println("<h1>" + name + "</h1>");
					  	
					  	String get_patients = "SELECT * FROM patients where center_id = "+id;
                		Statement s1 = connection.createStatement();

      				  	s1.executeQuery (get_patients);
                		ResultSet  r = s1.getResultSet();
                		
                		int patients_number = 0;
                		while (r.next()) {
                			patients_number = patients_number + 1;
                		}
                		out.println("<h5>Previous month vaccinated patients: <span>"+ patients_number +"</span></h5>");
                		out.println("<h5>Previous month patients: <span><form action='update_center' method='POST'><input type='number' name='number' value="+ previous_month_patients_no +"></span><input type='submit' value='update'></form></h5>");
					  	out.println("</div>");
	                  out.println("</div>");   
	         	  }
		          
				  rs.close ();
			
				  s.close ();

			}catch(Exception e){

				System.out.println("Exception is ;"+e);

			}
		
	    
	    return SKIP_BODY;//will not evaluate the body content of the tag  
	}  
}
