package org.health.administration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID =1L ;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String email = request.getParameter("email");
		String password = request.getParameter("password");
		String cpassword = request.getParameter("cpassword");
		String center = request.getParameter("center");
		
		if (password.equals(cpassword)) {
			String credentials = email+"``"+password+"``"+center;
			
	    	request.setAttribute("credentials", credentials);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/adminhome.jsp");
			dispatcher.forward(request, response);
		}
		else{
			request.setAttribute("message","Password MisMatch. Please try again");
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/register_admin.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

}
