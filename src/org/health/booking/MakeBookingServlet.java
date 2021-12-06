package org.health.booking;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

/**
 * Servlet implementation class MakeBookingServlet
 */
@WebServlet("/MakeBookingServlet")
public class MakeBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private String jdbcURL = "jdbc:mysql://localhost:3306/vaccination_db?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeBookingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//    JspWriter out=pageContext.getOut();//returns the instance of JspWriter  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String health_center = request.getParameter("center");
		String vaccine = request.getParameter("vaccine");
		
		request.setAttribute("date", date);
		request.setAttribute("time", time);
		request.setAttribute("center", health_center);
		request.setAttribute("vaccine", vaccine);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsps/booking/make_booking.jsp");
		dispatcher.forward(request, response);

	}

}
