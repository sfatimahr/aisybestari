package aisybestari.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aisybestari.dao.StudentDAO;
import aisybestari.model.Student;


/**
 * Servlet implementation class StudentController
 */
@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String MAIN_PAGE = "index.jsp";
	private static String LIST_STUDENT = "viewStudentList.jsp";	
	private static String VIEW_STUDENT = "viewStudent.jsp";
	private static String UPDATE_STUDENT = "updateStudent.jsp";
	private static String MY_ACC = "myAccount.jsp";
	
	private StudentDAO daoStudent;
	
	String forward="";	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        daoStudent = new StudentDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("listStudent")) {
			forward = LIST_STUDENT;
            request.setAttribute("students", daoStudent.getAllStudent());
					
		} else if (action.equalsIgnoreCase("viewStudent")) {
        	
        	String id= request.getParameter("id");
        	
        	Student student = new Student();
        	student = daoStudent.getStudentById(id);        	
        	
        	forward = VIEW_STUDENT;       		
            request.setAttribute("student", student);        	
      
		} else if (action.equalsIgnoreCase("updateStudent")) {	
        	
        	String id= request.getParameter("id");
        	
        	Student student = new Student();
        	student = daoStudent.getStudentById(id);
        	        	        	
        	forward = UPDATE_STUDENT;
            request.setAttribute("student", student); 
	
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
		String studId = request.getParameter("studId");
		String studName = request.getParameter("studName");
		String age = request.getParameter("age");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		String email = request.getParameter("email");
		String studUser = request.getParameter("studUser");
		String studPassword = request.getParameter("studPassword");
		String action = request.getParameter("action");
		
		Student student = new Student(studId, studName, age, address, contact, email, studUser, studPassword);				
		
		student = daoStudent.getStudent(student);

		try {
			if(action.equals("register")){			
				System.out.println("inserting student");
	        	daoStudent.add(student);       	
	        	response.sendRedirect("addEnrollment.jsp");
			} else if (daoStudent.validate(student)) {
            	request.getSession().setAttribute("auth", student);
            	student = daoStudent.studLogin(studUser, studPassword);        	
   
            	RequestDispatcher view = request.getRequestDispatcher(MY_ACC);
    			request.setAttribute("student", student);
    			view.forward(request, response);
            } else {
            	response.sendRedirect("student.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
	} 

}


