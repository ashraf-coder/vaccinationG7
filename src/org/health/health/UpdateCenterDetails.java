package org.health.health;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateCenterDetails
 */
@WebServlet("/UpdateCenterDetails")
public class UpdateCenterDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCenterDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> data = new ArrayList<String>();
		
		String number = request.getParameter("number");
		String center_id = request.getParameter("center_id");
		
    	request.setAttribute("number", number);
    	request.setAttribute("center_id", center_id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsps/healthcenter/update_health_center.jsp");
		dispatcher.forward(request, response);
	}

}
