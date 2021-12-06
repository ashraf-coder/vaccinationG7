package org.health.booking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class UpDateCenterDetailsTagHandler extends TagSupport {
	private static String table;
	private static String value;
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/vaccination_db?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    
	public void setTable(String table) {  
	    this.table = table;  
	}
	public void setValue(String value) {  
	    this.value = value;  
	}
	
	public int doStartTag() throws JspException {
		Connection connection = null;
		
	    JspWriter out=pageContext.getOut();//returns the instance of JspWriter  
	    try {

			 // Load the database driver

			  Class.forName(jdbcDriver);

			  // Get a Connection to the database

			  connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword); 

			  String sql = "UPDATE health_centers SET previous_month_patients_no = ? WHERE booking_id = 4";
			  
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setString(1, value);
	            
	            
	            int i = preparedStatement.executeUpdate();
	            if(i>0){
	            	out.println("<h1>SUCCESFULLY MADE BOOKING</h1>");
	            }

		}catch(Exception e){

			System.out.println("Exception is ;"+e);

		}
	    
	    return SKIP_BODY;//will not evaluate the body content of the tag  
	}  
}
