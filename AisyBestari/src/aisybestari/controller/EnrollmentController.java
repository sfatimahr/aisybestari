package aisybestari.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aisybestari.dao.EnrollmentDAO;
import aisybestari.model.Enrollment;

/**
 * Servlet implementation class EnrollmentController
 */
@WebServlet("/EnrollmentController")
public class EnrollmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String MAIN_PAGE = "index.jsp";
	private static String VIEW_ENROLLMENT = "viewEnrollment.jsp";
	private static String LIST_ENROLLMENT = "viewEnrollmentList.jsp";
	private static String UPDATE_ENROLLMENT = "updateEnrollment.jsp";
       
    private EnrollmentDAO daoEnrollment;
    
    String forward = "";
    
    public EnrollmentController() {
        super();
        daoEnrollment = new EnrollmentDAO(null);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("listEnrollment")) {
			forward = LIST_ENROLLMENT;
			request.setAttribute("enrollments", daoEnrollment.getAllEnrollment());
			
		} else if (action.equalsIgnoreCase("updateEnrollment")) {	
        	
        	String id= request.getParameter("id");
        	
        	Enrollment enrollment = new Enrollment();
        	enrollment = daoEnrollment.getEnrollmentById(id);
        	        	        	
        	forward = UPDATE_ENROLLMENT;
            request.setAttribute("enrollment", enrollment); 
	
        } else {
			forward = MAIN_PAGE;
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("enrollId");
		String date = request.getParameter("enrollDate");
		String status = request.getParameter("enrollStatus");
		String student = request.getParameter("studId");
		String staff = request.getParameter("staffId");
		String totalPayment = request.getParameter("totalPayment");
		
		Enrollment enrollment = new Enrollment(id, date, status, student, staff, totalPayment);
		
		enrollment = daoEnrollment.getEnroll(enrollment);
		
		if(!enrollment.isValid()){			
			System.out.println("inserting enrollment");
        	daoEnrollment.add(enrollment);       	
        	response.sendRedirect("student.jsp");
		}  else {

			System.out.println("enrollment already exist");
			daoEnrollment.updateEnrollment(enrollment);
			
			RequestDispatcher view = request.getRequestDispatcher(VIEW_ENROLLMENT);
			request.setAttribute("enrollment", enrollment);
			view.forward(request, response);
		}
	}

}
