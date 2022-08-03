package aisybestari.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aisybestari.dao.FulltimeDAO;
import aisybestari.dao.StaffDAO;
import aisybestari.model.Fulltime;
import aisybestari.model.Staff;



/**
 * Servlet implementation class SubjectController
 * @param <daoStaff>
 * @param <daoStaff>
 */
@WebServlet("/StaffController")
public class StaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String MAIN_PAGE = "index.jsp";
	private static String LIST_STAFF = "viewStaffList.jsp";		
	private static String VIEW_STAFF = "viewStaff.jsp";
	private static String UPDATE_STAFF = "updateStaff.jsp";
	private static String ADD_STAFF = "registerStaff.jsp";
	private static String VIEW_FULLTIME = "viewFulltime.jsp";
	private static String UPDATE_FULLTIME = "updateFulltime.jsp";
	
	private StaffDAO daoStaff;
	private FulltimeDAO daoFulltime;
	
	String forward="";	
    /**
     * Default constructor. 
     */
    public StaffController() {
    	 super();
         daoStaff = new StaffDAO();
         daoFulltime=new FulltimeDAO();
     }

    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get action parameter
				String action = request.getParameter("action");
				
		
		/**HttpSession session = request.getSession(false); //Fetch session object

		    if(session!=null) //If session is not null
		    {
		        session.invalidate(); //removes all session attributes bound to the session
		        request.setAttribute("errMessage", "You have logged out successfully");
		        RequestDispatcher requestDispatcher = request.getRequestDispatcher("StaffLogin.jsp");
		        requestDispatcher.forward(request, response);
		        System.out.println("Logged out");
		    }
		
		**/
		
		if (action.equalsIgnoreCase("listStaff")) {
			forward = LIST_STAFF;
            request.setAttribute("staffs", daoStaff.getAllStaff());
		}
		 else if (action.equalsIgnoreCase("deleteStaff")) {

			 	String id= request.getParameter("id");
			 	
				// to get the status of staff based on the id
				Staff staff = new Staff();
	        	staff = daoStaff.getStaffById(id);

				daoStaff.deleteStaff(id);
				
				//delete record from child
				if (staff.getStatus().equalsIgnoreCase("FULLTIME")) {
	        		daoFulltime.deleteFulltime(id);	
	        	}
				
				
				forward = LIST_STAFF;
				request.setAttribute("staffs", daoStaff.getAllStaff()); 
		 }	
		 else if (action.equalsIgnoreCase("viewStaff")) {
		        	
			 String id= request.getParameter("id");
		        	
		       Staff staff = new Staff();
		       staff = daoStaff.getStaffById(id);        	
		        	
		       // get details for manager
		       Staff manager = new Staff();
		       manager = daoStaff.getStaffById(staff.getManagerId());
		        	
		       // set manager in staff
		       staff.setManager(manager);
		      
	         // view fulltime instead of staff
	        	if (staff.getStatus().equalsIgnoreCase("FULLTIME")) {

	        		Fulltime fulltime = new Fulltime();
	        		fulltime = daoFulltime.getFulltimebyId(staff);
	        		forward = VIEW_FULLTIME;
	        		request.setAttribute("FULLTIME", fulltime); 
	        	}
	        	
	        	
	        	else 
	        		{forward = VIEW_STAFF;       		
		       request.setAttribute("staff", staff);  
	        		}      
		 }
		 else if (action.equalsIgnoreCase("updateStaff")) {	
	        	
			 String id= request.getParameter("id");
	        	
	        	 Staff staff = new Staff();
			      staff = daoStaff.getStaffById(id);  
	        	
			   // get details for manager
			       Staff manager = new Staff();
			       manager = daoStaff.getStaffById(staff.getManagerId());
			        	
			       // set manager
			       staff.setManager(manager);
	        
	         // update fulltime instead of staff
	        	
	        	if (staff.getStatus().equalsIgnoreCase("FULLTIME")) {

	        		Fulltime fulltime = new Fulltime();
	        		fulltime = daoFulltime.getFulltimebyId(staff);
	        		forward = UPDATE_FULLTIME;
	        		request.setAttribute("FULLTIME", fulltime);
	        	}
	        	
	        	else {
	        	forward = UPDATE_STAFF;
	            request.setAttribute("staff", staff); 
	        	}  
		 }
		
		 else if (action.equalsIgnoreCase("addStaff")) {	

				//get list of managers
			List<Staff> managers = daoStaff.getAllStaff();
			//List<String> managers = daoStaff.getManagerName();
	        	  	
	        	forward = ADD_STAFF;
	            request.setAttribute("managers", managers); 
		
	 } else
	 	{
		forward = MAIN_PAGE;
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
			
		        		
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String staffId = request.getParameter("staffId");
		String staffUser = request.getParameter("staffUser");
		String staffPassword = request.getParameter("staffPassword");
		String staffRole = request.getParameter("staffRole");
		String managerId =request.getParameter("managerId");
		String status = request.getParameter("status");
		String fixedAllowance=request.getParameter("fixedAllowance");
		
		/**if(status.equalsIgnoreCase("FULLTIME"))
			 fixedAllowance=request.getParameter("fixedAllowance");
			
		 
		 else if(status.equalsIgnoreCase("PARTTIME"))
			 status = request.getParameter("status");**/
			 
		Staff staff = new Staff(staffId,staffUser,staffPassword,staffRole,managerId,status);				
		
		staff = daoStaff.getStaff(staff);
	
		staff.setStaffUser(staffUser);
		staff.setStaffPassword(staffPassword);
		
		 try
		    {
		        String userValidate = daoStaff.authenticateUser(staff);
		 
		        if(userValidate.equals("Manager_Role"))
		        {
		            System.out.println("Manager Page");
		 
		            HttpSession session = request.getSession(); //Creating a session
		            session.setAttribute("MANAGER", staffUser); //setting session attribute
		            request.setAttribute("staffUser", staffUser);
		 
		            request.getRequestDispatcher("staffManagerLogin.jsp").forward(request, response);
		        }
		       
		        else if(userValidate.equals("Staff_Role"))
		        {
		            System.out.println("Home");
		 
		            HttpSession session = request.getSession();
		            session.setMaxInactiveInterval(10*60);
		            session.setAttribute("STAFF", staffUser);
		            request.setAttribute("staffUser", staffUser);
		 
		            request.getRequestDispatcher("StaffLogin.jsp").forward(request, response);
		        }
		        else
		        {
		            System.out.println("Error message = "+userValidate);
		            request.setAttribute("errMessage", userValidate);
		 
		            request.getRequestDispatcher("staff.jsp").forward(request, response);
		        }
		    }
		    catch (IOException e1)
		    {
		        e1.printStackTrace();
		    }
		    catch (Exception e2)
		    {
		        e2.printStackTrace();
		    }
		
			if(!staff.isValid()){			
			System.out.println("inserting staff");
        	daoStaff.add(staff);  
        	
        	// inheritance - to add in fulltime
        	if (staff.getStatus().equals("FULLTIME")) {
				Fulltime fulltime = new Fulltime (staffId,staffUser,staffPassword,staffRole,managerId,status,fixedAllowance);
				
				try {
					daoFulltime.add(fulltime);
				} 
				catch (NoSuchAlgorithmException e) {					
					e.printStackTrace();
				}
			}
        	response.sendRedirect("registerStaff.jsp");
			} 
			//update existing record
			else {

			System.out.println("staff already exist");
			daoStaff.updateStaff(staff);
			
			// get details for manager
        	Staff manager= new Staff();
        	manager = daoStaff.getStaffById(staff.getManagerId());
        	
        	// set manager in staff
        	staff.setManager(manager);
        	
        	
			if (status.equalsIgnoreCase("FULLTIME")) {
				Fulltime fulltime = new Fulltime (staffId,staffUser,staffPassword,staffRole,managerId,status,fixedAllowance);
				daoFulltime.updateFulltime(fulltime);
				
				//RequestDispatcher viewFulltime = request.getRequestDispatcher(VIEW_FULLTIME);
				request.setAttribute("FULLTIME", daoFulltime.getFulltimebyId(staff));
				//viewFulltime.forward(request, response);
			}

        	RequestDispatcher view = request.getRequestDispatcher(VIEW_STAFF);
			request.setAttribute("staff", staff);
			view.forward(request, response);
		
			
			}  
	}
}

		
		  
		
	

	
	



