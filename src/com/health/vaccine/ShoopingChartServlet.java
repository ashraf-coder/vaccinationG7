package com.health.vaccine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.productManagement.Product;

/**
 * 
 * 
 * NYANZI ASHRAF 19/U/13235/PS
 * 
 * 
 * 
 */

public class ShoopingChartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoopingChartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameterValues("selected") != null) {
			String[] selected = request.getParameterValues("selected");
			int visits = Integer.parseInt(request.getParameter("visits"));
			String ranking = "";
			
			if (visits >= 30) {
				ranking = "GOLD";
			}else if (visits >= 15) {
				ranking = "Silver";
			}else if (visits >= 9) {
				ranking = "Bronze";
			}else if (visits < 9 ) {
				ranking = "Guest";
			}
			
			List<String> products = new ArrayList<>();
			
			for(int i=0;i<selected.length;i++){
				products.add(selected[i]);
		    }
			/////////database query required
			
			response.setContentType("text/html");
			request.setAttribute("shopping_chart_list", products);
			request.setAttribute("ranking", ranking);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsps/shooping_chart.jsp");
			dispatcher.forward(request, response);
		}else{
			int visits = Integer.parseInt(request.getParameter("visits"));
			String ranking = "";
			
			if (visits >= 30) {
				ranking = "GOLD";
			}else if (visits >= 15) {
				ranking = "Silver";
			}else if (visits >= 9) {
				ranking = "Bronze";
			}else if (visits < 9 ) {
				ranking = "Guest";
			}
			response.setContentType("text/html");
			request.setAttribute("ranking", ranking);
			request.setAttribute("shopping_chart_list", "no item selected");
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsps/shooping_chart.jsp");
			dispatcher.forward(request, response);
		}
	}

}
