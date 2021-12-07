package org.health.administration;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterPatient
 */
@WebServlet("/RegisterPatient")
public class RegisterPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterPatient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		request.getRequestDispatcher("WEB-INF/jsps/admin/view_patients.jsp").forward(request, response);
		String email = request.getParameter("email");
		String nin = request.getParameter("nin");
		String name = request.getParameter("name");
		String doa = request.getParameter("doa");
		String batch_no = request.getParameter("batch_no");
		String vaccine = request.getParameter("vaccine_id");
		String center = request.getParameter("center");
		
		request.setAttribute("email", email);
		request.setAttribute("nin", nin);
		request.setAttribute("name", name);
		request.setAttribute("doa", doa);
		request.setAttribute("batch_no", batch_no);
		request.setAttribute("vaccine_id", vaccine);
		request.setAttribute("center_id", center);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsps/admin/patient_register.jsp");
		dispatcher.forward(request, response);
	}

}
