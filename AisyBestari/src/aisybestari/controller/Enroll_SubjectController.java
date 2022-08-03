package aisybestari.controller;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aisybestari.dao.Enroll_SubjectDAO;
import aisybestari.dao.EnrollmentDAO;
import aisybestari.dao.SubjectDAO;
import aisybestari.model.Enroll_Subject;
import aisybestari.model.Enrollment;
import aisybestari.model.Subject;

/**
 * Servlet implementation class Enroll_SubjectController
 */
@WebServlet("/Enroll_SubjectController")
public class Enroll_SubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Enroll_SubjectDAO daoEnroll_Subject;
	private EnrollmentDAO daoEnrollment;
	private SubjectDAO daoSubject;
	
	private static String MAIN_PAGE = "index.jsp";
	private static String LIST_ENROLLMENT = "viewEnrollmentListforEnroll_Subject.jsp";
	private static String LIST_SUBJECT_BY_ENROLLMENT = "viewSlotListByEnrollment.jsp";
	
	String forward = "";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Enroll_SubjectController() {
        super();
        daoEnroll_Subject = new Enroll_SubjectDAO();
        daoSubject = new SubjectDAO(null);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");		
		
		if(action.equalsIgnoreCase("listEnrollment")) {
			
			forward = LIST_ENROLLMENT;
			request.setAttribute("enrollments", daoEnrollment.getAllEnrollment());
			
		} else if (action.equalsIgnoreCase("listSlot")) {
			
			String id = request.getParameter("id");
			Enrollment enrollment = new Enrollment();
			enrollment = daoEnrollment.getEnrollmentById(id);
			
			List<Enroll_Subject> enroll_subjects = new ArrayList<Enroll_Subject>();
			//enroll_subjects = daoEnroll_Subject.getAllSubjectsByEnrollment(id);
			enrollment.setEnroll_Subjects(enroll_subjects);
			
			forward = LIST_SUBJECT_BY_ENROLLMENT;
			request.setAttribute("enrollment", enrollment);
			
		} else if(action.equalsIgnoreCase("getSubjectId")) {
			
			String subjectId = request.getParameter("id");
			request.setAttribute("subjectId", subjectId);
			
		} else if(action.equalsIgnoreCase("enroll")) {
			
			String subjectId = request.getParameter("subjectId");
			String slotId = request.getParameter("slotId");
			
			Enroll_Subject enroll_subject = new Enroll_Subject();
			enroll_subject = daoEnroll_Subject.add(subjectId, slotId);
			
			request.setAttribute("enroll_subject", enroll_subject);
			
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

		List<Subject> subjects  = daoSubject.getAllSubject();
		request.setAttribute("subjects", subjects);
		
		String subjectId = request.getParameter("subjectId");		
		String slotId = request.getParameter("slotId");

		System.out.println("adding");
		daoEnroll_Subject.add(subjectId, slotId);
		
		response.sendRedirect("SlotController?action=enroll");
	}

}
