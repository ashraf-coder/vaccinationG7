package org.health.vaccine;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddVaccineServlet
 */

public class AddVaccineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddVaccineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String number_of_doses = request.getParameter("number_of_doses");
		String number_of_shots = request.getParameter("number_of_shots");
		String period_btn_shots = request.getParameter("period_btn_shots");
		
		
		request.setAttribute("name", name);
		request.setAttribute("number_of_doses", number_of_doses);
		request.setAttribute("number_of_shots", number_of_shots);
		request.setAttribute("period_btn_shots", period_btn_shots);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsps/add_vaccine_data.jsp");
		dispatcher.forward(request, response);
		
	}

}
