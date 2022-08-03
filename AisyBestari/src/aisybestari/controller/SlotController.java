package aisybestari.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aisybestari.dao.Enroll_SubjectDAO;
import aisybestari.dao.SlotDAO;
import aisybestari.dao.SubjectDAO;
import aisybestari.model.Enroll_Subject;
import aisybestari.model.Slot;
import aisybestari.model.Subject;
/**
 * Servlet implementation class SlotController
 */
@WebServlet("/SlotController")
public class SlotController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String VIEW_SLOT = "viewSlot.jsp";
	private static String LIST_SLOT = "viewSlotList.jsp";
	private static String UPDATE_SLOT = "updateSlot.jsp";
	private static String LIST_SLOT_BY_ENROLLMENT = "viewSlotListByEnrollment.jsp";
	
	private SlotDAO daoSlot;
	private SubjectDAO daoSubject;
	private Enroll_SubjectDAO daoEnroll_Subject;
	
	String forward = "";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SlotController() {
        super();
        daoSlot = new SlotDAO(null);
        daoSubject = new SubjectDAO(null);
        daoEnroll_Subject = new Enroll_SubjectDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("listSlot")) {
			
			forward = LIST_SLOT;
            request.setAttribute("slots", daoSlot.getAllSlot());
					
		} else if (action.equalsIgnoreCase("deleteSlot")) {

			String id= request.getParameter("id");

			daoSlot.deleteSlot(id);

			forward = LIST_SLOT;
			request.setAttribute("slots", daoSlot.getAllSlot()); 

		}	else if (action.equalsIgnoreCase("viewSlot")) {
        	
        	String id= request.getParameter("id");
        	
        	Slot slot = new Slot();
        	slot = daoSlot.getSlotById(id);        	
        	
        	forward = VIEW_SLOT;       		
            request.setAttribute("slot", slot);        	
      
		} else if (action.equalsIgnoreCase("updateSlot")) {	
        	
        	String id= request.getParameter("id");
        	
        	Slot slot = new Slot();
        	slot = daoSlot.getSlotById(id);        	
        	        	        	
        	forward = UPDATE_SLOT;
            request.setAttribute("slot", slot); 
	
        } else if (action.equalsIgnoreCase("listEnrollment")) {

			String id = request.getParameter("id");
			Slot slot = new Slot();
			slot = daoSlot.getSlotById(id);

			List<Enroll_Subject> enroll_subjects = new ArrayList<Enroll_Subject>();
			enroll_subjects = daoEnroll_Subject.getAllSlotsByEnrollment(id);
			slot.setEnroll_subjects(enroll_subjects);

			forward = LIST_SLOT_BY_ENROLLMENT;		
			request.setAttribute("slot", slot);

		} else if (action.equals("enroll")) {
			enrollSlot(request, response);
		} 		
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("slotId");
		String time = request.getParameter("slotTime");
		String day = request.getParameter("slotDay");
		String seat = request.getParameter("slotSeat");
		String subject = request.getParameter("subjectId");
		
		List<Subject> subjects = daoSubject.getAllSubject();
		request.setAttribute("subjects", subjects);
		
		Slot slot = new Slot(id, time, day, seat, subject);
		
		slot = daoSlot.getSlot(slot);
		
		if(!slot.isValid()){			
			System.out.println("inserting slot");
        	daoSlot.add(slot);       	
        	response.sendRedirect("/AisyBestari/SlotController?action=listSlot");
		}  else {

			System.out.println("slot already exist");
			daoSlot.updateSlot(slot);
			
			RequestDispatcher view = request.getRequestDispatcher(VIEW_SLOT);
			request.setAttribute("slot", slot);
			view.forward(request, response);
		}
	}
	
	protected void enrollSlot(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// get list of FK
		List<Slot> slots = daoSlot.getAllSlot();
		List<Subject> subjects = daoSubject.getAllSubject();
		
		// set attributes
		request.setAttribute("slots", slots);
		request.setAttribute("subjects", subjects);
		
		// forward to JSP
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("pickSlot.jsp");
		requestDispatcher.forward(request, response);

	}

}
