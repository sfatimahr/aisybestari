package aisybestari.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aisybestari.dao.SubjectDAO;
import aisybestari.model.Subject;

/**
 * Servlet implementation class SubjectController
 */
@WebServlet("/SubjectController")
public class SubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String MAIN_PAGE = "index.jsp";
	private static String LIST_SUBJECT = "viewSubjectList.jsp";	
	private static String VIEW_SUBJECT = "viewSubject.jsp";
	private static String UPDATE_SUBJECT = "updateSubject.jsp";
	
	private SubjectDAO daoSubject;
	
	String forward="";	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectController() {
        super();
        daoSubject = new SubjectDAO(null);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("listSubject")) {
			
			forward = LIST_SUBJECT;
            request.setAttribute("subjects", daoSubject.getAllSubject());
					
		} else if (action.equalsIgnoreCase("deleteSubject")) {

			String id= request.getParameter("id");

			daoSubject.deleteSubject(id);

			forward = LIST_SUBJECT;
			request.setAttribute("subjects", daoSubject.getAllSubject()); 

		} else if (action.equalsIgnoreCase("viewSubject")) {
        	
        	String id= request.getParameter("id");
        	
        	Subject subject = new Subject();
        	subject = daoSubject.getSubjectById(id);        	
        	
        	forward = VIEW_SUBJECT;       		
            request.setAttribute("subject", subject);        	
      
		} else if (action.equalsIgnoreCase("updateSubject")) {	
        	
        	String id= request.getParameter("id");
        	
        	Subject subject = new Subject();
        	subject = daoSubject.getSubjectById(id);
        	        	        	
        	forward = UPDATE_SUBJECT;
            request.setAttribute("subject", subject); 
	
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
		String subjectId = request.getParameter("subjectId");
		String subjectName = request.getParameter("subjectName");
		String lvl = request.getParameter("lvl");
		String fee = request.getParameter("fee");
		
		Subject subject = new Subject(subjectId, subjectName, lvl, fee);				
		
		subject = daoSubject.getSubject(subject);
	
		if(!subject.isValid()) {			
			System.out.println("inserting subject");
        	daoSubject.add(subject);       	
        	response.sendRedirect("/AisyBestari/SubjectController?action=listSubject");
		} else {

			System.out.println("subject already exist");
			daoSubject.updateSubject(subject);
			
			RequestDispatcher view = request.getRequestDispatcher(VIEW_SUBJECT);
			request.setAttribute("subject", subject);
			view.forward(request, response);
		}
	}

}
