package org.health.administration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

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
	                 flag = 1;
	                 out.println("<h1 style='color:green;'>You have Logged in successfully with the email "+email+"</h1>");
 			         out.println("<h3>Click <a href='booking_form'>here</a> to start booking</h3>");
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
