package org.health.health;

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
	private static String value1;
	private static String value2;
//	ArrayList<String> data = new ArrayList<>();
	
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
	
	public int doStartTag() throws JspException {
		Connection connection = null;
		
	    JspWriter out=pageContext.getOut();//returns the instance of JspWriter  
	    try {

			 // Load the database driver

			  Class.forName(jdbcDriver);

			  // Get a Connection to the database

			  connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword); 

			  String sql = "UPDATE health_centers SET previous_month_patients_no = ? WHERE center_id = ?";
			  
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setString(1, value1);
	            preparedStatement.setString(2, value2);
	            
	            
	            int i = preparedStatement.executeUpdate();
	            if(i>0){
	            	out.println("<div class='container text-center d-flex justify-content-center align-items-center' style='height: 100vh'>");
				  	out.println("<div>");
            		out.println("<h1 class='text-success'>Health center updated successfully</h1><br>");
            		out.println("<a class='text-decoration-none' href='center_home'><button class='btn btn-primary'>back to home</button></a>");
				  	out.println("</div>");
                  out.println("</div>"); 
	            }

		}catch(Exception e){

			System.out.println("Exception is ;"+e);

		}
	    
	    return SKIP_BODY;//will not evaluate the body content of the tag  
	}  
}
