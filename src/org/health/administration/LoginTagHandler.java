package org.health.administration;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZonedDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class LoginTagHandler extends TagSupport {
	private static final long serialVersionUID =1L ;
	
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
	    
	    String[] tables = table.split("``");
	    String[] credentials = where.split("``");
	    
		try {

			 // Load the database driver
				Class.forName(jdbcDriver);
		
				  // Get a Connection to the database
			
				connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword); 
			
				  //Select the data from the database
				
				String sql = "SELECT * FROM "+tables[0] +
						" WHERE email = \""+ credentials[0] +"\" AND password = \""+ credentials[1]+"\"";

				  Statement s = connection.createStatement();

				  s.executeQuery (sql);

				  ResultSet  rs = s.getResultSet();
				  
				  int flag = 0;
				 
	             while (rs.next()) {  
	                 String email = rs.getString("email"); 
	                 java.util.Date the_date = rs.getDate("date");
	                 flag = 1;
	                 out.println("<h1 style='color:green;'>You have Logged in successfully with the email "+email+"</h1>");
	                 
	                 java.util.Date tomorrowbutone = Date.from(java.time.ZonedDateTime.now().plusDays(1).toInstant());
	                 java.util.Date today = Date.from(java.time.ZonedDateTime.now().minusDays(1).toInstant());
	                 
	                 if(the_date.after(today) && the_date.before(tomorrowbutone)){
	                	 out.println("<h3>Email: Tomorrow is when you Booked to get the vaccine doze</h3>");
	                 }
	                 out.println("<h3>Click <a href='booking_form'>here</a> go to booking page</h3>");
 			         
	             }  
	             
	             if (flag == 0){
	            	 
	            	 String sql1 = "SELECT * FROM "+tables[1] +
	 						" WHERE email = \""+ credentials[0] +"\" AND password = \""+ credentials[1]+"\"";

	 				  Statement s1 = connection.createStatement();

	 				  s1.executeQuery (sql1);

	 				  ResultSet  rs1 = s1.getResultSet();
	 				  
	 				  int flag1 = 0;
	 				 
	 	             while (rs1.next()) {  
	 	                 String email = rs1.getString("email");  
	 	                 flag1 = 1;
	 	                 
	 	                 int center_id = rs1.getInt("center_id");
//	 	                 if(center_id == 0){
//	 	                	 
//	 	                 }else{
//	 	                	 
//	 	                 }
	 	                 out.println("<h1 style='color:green;'>You have Logged in successfully with the email "+email+"</h1>");
				         out.println("<h3>Click <a href='admin_home_view'>here</a> to start administration work</h3>");
	 	             }
	            	 
	 	            if (flag1 == 0){
	            	 out.println("<h1 style='color:red;'>Wrong Credentials entered</h1>");
			         out.println("<h3>Click <a href='login'>here</a> to try again</h3>");
	 	            }
	             }
	             rs.close ();
	             s.close ();
	    	}
		catch(Exception e){

				System.out.println("Exception is ;"+e);

			}
	    
	    return SKIP_BODY;//will not evaluate the body content of the tag  
	}  
}
