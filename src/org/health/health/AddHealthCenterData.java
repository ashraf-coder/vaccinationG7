package org.health.health;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddHealthCenterData
 */
@WebServlet("/AddHealthCenterData")
public class AddHealthCenterData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddHealthCenterData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String data = request.getParameter("center");
		
    	request.setAttribute("data", data);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsps/healthcenter/add_health_center.jsp");
		dispatcher.forward(request, response);
		
	}

}
