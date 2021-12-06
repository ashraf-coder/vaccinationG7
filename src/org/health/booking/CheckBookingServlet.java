package org.health.booking;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckBookingServlet
 */
@WebServlet("/CheckBookingServlet")
public class CheckBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckBookingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String date_name = request.getParameter("date");
		
		request.setAttribute("date", date_name);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsps/booking/check_queues.jsp");
		dispatcher.forward(request, response);
	}

}
