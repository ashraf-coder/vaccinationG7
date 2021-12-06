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

public class MakeBookingTagHandler extends TagSupport {
	private static String table;
	private static String value1; 
	private static String value2;
	private static String value3;
	private static String value4;
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/vaccination_db?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    
	public void setTable(String table) {  
	    this.table = table;  
	}
	public void setValue1(String value1) {  
	    this.value1 = value1;  
	}
	public void setValue2(String value2) {  
	    this.value2 = value2;  
	}
	public void setValue3(String value3) {  
	    this.value3 = value3;  
	}
	public void setValue4(String value4) {  
	    this.value4 = value4;  
	}
	
	public int doStartTag() throws JspException {
		Connection connection = null;
		
	    JspWriter out=pageContext.getOut();//returns the instance of JspWriter  
	    try {

			 // Load the database driver

			  Class.forName(jdbcDriver);

			  // Get a Connection to the database

			  connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword); 

			  String sql = "UPDATE bookings SET time = ?, date = ?, center_id = ?, vaccine_id = ? WHERE booking_id = 4";
			  
			  
		
			  
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setString(1, value2); //date
	            preparedStatement.setString(2, value1); //time
	            preparedStatement.setInt(3, Integer.parseInt(value3)); //center
	            preparedStatement.setInt(4, Integer.parseInt(value4));
	            
	            
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
