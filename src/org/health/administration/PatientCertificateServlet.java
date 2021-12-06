package org.health.administration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PatientCentificateServlet
 */
@WebServlet("/PatientCentificateServlet")
public class PatientCertificateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientCertificateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nin = request.getParameter("nin");
		
		request.setAttribute("nin", nin);
		request.getRequestDispatcher("WEB-INF/jsps/admin/patient_certificate.jsp").forward(request, response);
	}

}
