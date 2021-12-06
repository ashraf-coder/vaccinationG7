package org.health.administration;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class RegisterTagHandler extends TagSupport {
	private static String table;
	private static String value1; 
	private static String value2;
	private static String value3;
	private static String value4;
	private static String value5;
	private static String value6;
	
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
	public void setValue5(String value5) {  
		this.value5 = value5;
	}
	public void setValue6(String value6) {  
	    this.value6 = value6;  
	}
	
	public int doStartTag() throws JspException {
		Connection connection = null;
		
	    JspWriter out=pageContext.getOut();//returns the instance of JspWriter  
	    try {

			 // Load the database driver

			  Class.forName(jdbcDriver);

			  // Get a Connection to the database

			  connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword); 
			  	
			  int vac_id = Integer.parseInt(value6) ;
			    String get_vaccines = "SELECT * FROM vaccines WHERE vaccine_id ="+ vac_id +";";
				
				Statement s6 = connection.createStatement();

				s6.executeQuery (get_vaccines);
				

			    ResultSet  rs6 = s6.getResultSet();
				int period_btn_shots = 0;
			 	while (rs6.next()) {  
	                period_btn_shots = rs6.getInt("period_btn_shots");  //period btn shots  
			 	}
			 	LocalDate date = LocalDate.parse(value4);
			 	LocalDate date2 = date.plusDays(period_btn_shots);
			 	  
			 	  
			 	String sql = "INSERT INTO patients" +
				            "  (email, nin, name, doa, batch_no, vaccine_id, date_of_return) VALUES " +
				            " (?, ?, ?, ?, ?, ?, ?);";

				PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setString(1, value1);
	            preparedStatement.setString(2, value2);
	            preparedStatement.setString(3, value3);
	            preparedStatement.setString(4, value4);
	            preparedStatement.setInt(5, Integer.parseInt(value5)); //center
	            preparedStatement.setInt(6, Integer.parseInt(value6));
	            preparedStatement.setString(7, date2.toString());
	            
	            
	            int i = preparedStatement.executeUpdate();
	            if(i>0){
	            	out.println("<h1>SUCCESFULLY ADDED PATIENT</h1>");
	            }

		}catch(Exception e){

			System.out.println("Exception is ;"+e);

		}
	    
	    return SKIP_BODY;//will not evaluate the body content of the tag  
	}  
}
