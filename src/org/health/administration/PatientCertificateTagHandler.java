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

public class PatientCertificateTagHandler extends TagSupport {
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
				  String get_patient = "SELECT * FROM "+ table +" where nin = \""+ where +"\"";

				  Statement s = connection.createStatement();

				  s.executeQuery (get_patient);

				  ResultSet  rs = s.getResultSet();
				  
				  while (rs.next()) { 
					  String name = rs.getString("name");    
	                  out.println("<h1>" + name + "</h1>");   
	         	  }
		          
				  rs.close ();
			
				  s.close ();

			}catch(Exception e){

				System.out.println("Exception is ;"+e);

			}
		
	    
	    return SKIP_BODY;//will not evaluate the body content of the tag  
	}  
}
