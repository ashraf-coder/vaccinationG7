package org.health.vaccine;

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

public class DistributionTagHandler extends TagSupport {
	private static String table; 
	private static String where;
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/vaccination_db?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    
	public void setTable(String table) {  
	    this.table = table;  
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

			  String sql1 = "SELECT * FROM patients";
			  
			  
			  Statement s1 = connection.createStatement();

			  s1.executeQuery (sql1);

			  ResultSet  rs1 = s1.getResultSet();
			  
			  int total_patients = 0;
			  while (rs1.next()) {
				  total_patients = total_patients + 1;
			  }
			  
			  
			  //Select the data from the database

			  String sql = "SELECT * FROM "+table;
			  
			  
			  Statement s = connection.createStatement();

			  s.executeQuery (sql);

			  ResultSet  rs = s.getResultSet();
			  
			  int total_previous_month_patients_no = 0;
			  ArrayList<Integer> centers_that_didnt_vaccinate = new ArrayList<>();
			  
			  while (rs.next()) {  
                 String name = rs.getString("name");
                 int id = rs.getInt("center_id");
                 int previous_month_patients_no = rs.getInt("previous_month_patients_no");
                 
                 
                 String get_vaccines = "SELECT * FROM patients where center_id = "+id;
         		 Statement s2 = connection.createStatement();

         		 s2.executeQuery (get_vaccines);
         		 ResultSet  rs2 = s2.getResultSet();
         		
         		 int total_vaccinated_patients = 0;
         		 
         		 while (rs2.next()) { 
         			total_vaccinated_patients = total_vaccinated_patients + 1;
         		 }
         		 
         		 if (total_vaccinated_patients == 0) {
         			total_previous_month_patients_no = total_previous_month_patients_no + (previous_month_patients_no + 1);
         			
         			centers_that_didnt_vaccinate.add(id);
         		 }
         		 
			  }
			  
			  while (rs.next()) {  
				 String name = rs.getString("name");
                 int id = rs.getInt("center_id");
                 int previous_month_patients_no = rs.getInt("previous_month_patients_no");
                 
	                 String get_vaccines = "SELECT * FROM patients where center_id = "+id;
	         		 Statement s3 = connection.createStatement();
	
	         		 s3.executeQuery (get_vaccines);
	         		 ResultSet  rs3 = s3.getResultSet();
	         		
	         		 int total_vaccinated_patients = 0;
	         		 
	         		 while (rs3.next()) { 
	         			total_vaccinated_patients = total_vaccinated_patients + 1;
	         		 }
	         		 
	         		 int ratio = (total_patients + 1)/total_patients;
         		 
	         	if(centers_that_didnt_vaccinate.contains(id)){
	         		ratio = (previous_month_patients_no/total_previous_month_patients_no) * centers_that_didnt_vaccinate.size() * ratio;
            	}
         		 
	         	
		  	}

		}catch(Exception e){

			System.out.println("Exception is ;"+e);

		}
	    
	    return SKIP_BODY;//will not evaluate the body content of the tag  
	}  
}
