package org.health.booking;

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

public class VaccinesTagHandler extends TagSupport {
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
				  
				  out.println("<div class='container d-flex justify-content-center flex-wrap'>");
					  while (rs.next()) {  
		                 String name = rs.getString("name");
		                 int id = rs.getInt("center_id");
		                 
		                out.println("<div class='card m-2'>");
		                	out.println("<div class='card-body'>");
		                		out.println("<h4 class='card-title'>"+ name +"</h4>");
		                		out.println("<h5>time queues</h5>");
		                		
		                		out.println("<h5>available vaccines</h5>");
		 
		                		String get_vaccines = "SELECT * FROM health_centers_vaccines where center_id = "+id;
		                		Statement s1 = connection.createStatement();

		      				  	s1.executeQuery (get_vaccines);
		                		ResultSet  r = s1.getResultSet();
		                		
		                		while (r.next()) { 
		                			int vaccine_id = r.getInt("vaccine_id");
		                			String get_vaccines_names = "SELECT * FROM vaccines where vaccine_id = "+vaccine_id;
		                			Statement s2 = connection.createStatement();

			      				  	s2.executeQuery (get_vaccines_names);
		          				    
		          				    ResultSet  rv = s2.getResultSet();
		          				    
		          				    out.println("<ul>");
				          				while (rv.next()) { 
				          					String vaccine_name = rv.getString("name");
				          					out.println("<li>"+ vaccine_name +"</li>");
				          				}
			          				out.println("</ul>");
		                		}
		                		
		                	out.println("</div>");
		                 out.println("</div>");
		                  
		         	  }
				  out.println("</div>");
				  
				  out.println("<div class='container text-center'>");
					  out.println("<form action='check_booking' method='POST'>");
					  	  out.println("<label  for='date'>date</label>");
						  out.println("<input  id='date' name='date' type='date'>");
						  out.println("<input type='submit' value='check'>");
					  out.println("</form"); 
				  out.println("</div>");
				  
				  out.println("<div class='container text-center'>");
				  	out.println("<form action='make_booking' method='POST'>");
					  	out.println("<label for='center'>choose health center</label>");
					    out.println("<select name='center' id='center'>");
					   
						    String get_centers = "SELECT * FROM health_centers";
		
							Statement s5 = connection.createStatement();
		
							s5.executeQuery (get_centers);
		
						    ResultSet  rs5 = s5.getResultSet();
							   
						 	while (rs5.next()) {  
				                 String name = rs5.getString("name");    
				                 out.println("<option value = "+ rs5.getInt("center_id") +">" + name + "</option>");   
						 	} 
					    
					    out.println("</select>");
					    
					  	out.println("<label for='center'>choose vaccine</label>");
					    out.println("<select name='vaccine' id='vaccine'>");
					   
						    String get_vaccines = "SELECT * FROM vaccines";
		
							Statement s6 = connection.createStatement();
		
							s6.executeQuery (get_vaccines);
		
						    ResultSet  rs6 = s6.getResultSet();
							   
						 	while (rs6.next()) {  
				                 String name = rs6.getString("name");    
				                 out.println("<option value = "+ rs6.getInt("vaccine_id") +">" + name + "</option>");   
						 	} 
					    
					    out.println("</select>");
					    
					    out.println("<label  for='date'>date</label>");
			    		out.println("<input  id='date' name='date' class='' type='date'>");
	    				out.println("<label for='time'>time</label>");
	    				out.println("<select name='time' id='time'>");
	    					out.println("<option>morning</option>");
	    					out.println("<option>afternoon</option>");
	    					out.println("<option>evening</option>");
    					out.println("</select>");
    					out.println("<input type='submit' value='book'>");
					out.println("</form>");
					out.println("</div>");
		          
				  rs.close ();
			
				  s.close ();

			}catch(Exception e){

				System.out.println("Exception is ;"+e);

			}
		} 
		
		if (table == "bookings") {
			Connection connection = null;
			
		    JspWriter out=pageContext.getOut();//returns the instance of JspWriter  
		    try {

				 // Load the database driver

				  Class.forName(jdbcDriver);

				  // Get a Connection to the database

				  connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword); 

				  //Select the data from the database

				  String sql = "SELECT * FROM health_centers";
				  
				  

				  Statement s = connection.createStatement();

				  s.executeQuery (sql);

				  ResultSet  rs = s.getResultSet();
				  
				  out.println("<div class='container d-flex justify-content-center'>");
					  while (rs.next()) {  
		                 String name = rs.getString("name");
		                 int id = rs.getInt("center_id");
		                 
		                out.println("<div class='card m-2'>");
		                	out.println("<div class='card-body'>");
		                		out.println("<h4 class='card-title'>"+ name +"</h4>");
		                		
		                		out.println("<h5>available vaccines</h5>");
		 
		                		String get_vaccines = "SELECT * FROM health_centers_vaccines where center_id = "+id;
		                		Statement s1 = connection.createStatement();

		      				  	s1.executeQuery (get_vaccines);
		                		ResultSet  r = s1.getResultSet();
		                		
		                		while (r.next()) { 
		                			int vaccine_id = r.getInt("vaccine_id");
		                			String get_vaccines_names = "SELECT * FROM vaccines where vaccine_id = "+vaccine_id;
		                			Statement s2 = connection.createStatement();

			      				  	s2.executeQuery (get_vaccines_names);
		          				    
		          				    ResultSet  rv = s2.getResultSet();
		          				    
		          				    out.println("<ul>");
				          				while (rv.next()) { 
				          					String vaccine_name = rv.getString("name");
				          					out.println("<li>"+ vaccine_name +"</li>");
				          				}
			          				out.println("</ul>");
		                		}
		                		
		                		
		                		String get_bookings = "SELECT * FROM bookings WHERE center_id="+ id +" AND date = \""+ where +"\"";
		                		
		                		Statement s3 = connection.createStatement();

		      				  	s3.executeQuery (get_bookings);
		                		ResultSet  rs4 = s3.getResultSet();
		                		
		                		int morning_sum = 0;
		                		int afternoon_sum = 0;
		                		int evening_sum = 0;
		                		
		                		while (rs4.next()) {
		                			String time = rs4.getString("time");
		                			
		                			if (time.equals("morning") == true) {
		                				morning_sum = morning_sum + 1;
									}
		                			
		                			if (time.equals("afternoon") == true) {
		                				afternoon_sum = afternoon_sum + 1;
									}
		                			
		                			if (time.equals("evening") == true) {
		                				evening_sum = evening_sum + 1;
									}
		                		}
		                		
		                		out.println("<h5>morning</h5>");
		                		
		                		out.println("<h5>"+ morning_sum +"</h5>");
		                		
		                		out.println("<h5>afternoon</h5>");
		                		
		                		out.println("<h5>"+ afternoon_sum +"</h5>");
		                		
		                		out.println("<h5>evening</h5>");
		                		
		                		out.println("<h5>"+ evening_sum +"</h5>");
		                		
		                	out.println("</div>");
		                 out.println("</div>");
		         
		         	  }
				  out.println("</div>");  
		          
				  rs.close ();
			
				  s.close ();

			}catch(Exception e){

				System.out.println("Exception is ;"+e);

			}
		}
		if (table == "patients") {
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
