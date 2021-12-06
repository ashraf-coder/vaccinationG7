package com.health.vaccine;

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

import com.productManagement.Product;


public class VaccinesTagHandler extends TagSupport {
	private static String table;  
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/vaccination_db?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    
	public void setTable(String table) {  
	    this.table = table;  
	} 
	
	
	public int doStartTag() throws JspException {
		Connection connection = null;
		
		
		List dataList = new ArrayList();
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
	             out.println("<tr><th>name</th><th>number of doses</th><th>number of shots</th><th>period btn shots</th><tr>");  
	             while (rs.next()) {  
	                 String name = rs.getString("name");  
	                 int no_of_doses = rs.getInt("no_of_doses");
	                 int no_of_shots = rs.getInt("no_of_shots");
	                 int period_btn_shots = rs.getInt("period_btn_shots");   
	                 out.println("<tr><td>" + name + "</td><td>" + no_of_doses + "</td><td>" + no_of_shots + "</td><td>" + period_btn_shots + "</td></tr>");   
	             }  
	          out.println("</table>");
	          
			  rs.close ();
		
			  s.close ();

		}catch(Exception e){

			System.out.println("Exception is ;"+e);

		}
	    
	    return SKIP_BODY;//will not evaluate the body content of the tag  
	}  
}
