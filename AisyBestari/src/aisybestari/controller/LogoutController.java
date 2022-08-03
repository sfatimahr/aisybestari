package aisybestari.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LogoutController")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	  public LogoutController() { super(); // TODO Auto-generated constructor stub
	  }
	 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (java.io.PrintWriter out = response.getWriter()) {
			
			if (request.getSession().getAttribute("auth") != null) {
				request.getSession().removeAttribute("auth");
				response.sendRedirect("student.jsp");
			} else {
				response.sendRedirect("index.jsp");
			}
			 
		} 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
