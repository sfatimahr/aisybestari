package aisybestari.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Document;

import aisybestari.connection.ConnectionManager;
import aisybestari.model.Staff;
import aisybestari.model.Student;

public class StaffDAO {

	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	static String id,username,password,role,managerId,status;

	
	public String authenticateUser(Staff staff) {
		
		String staffUser = staff.getStaffUser();
	    String staffPassword = staff.getStaffPassword();
	    String staffRole=staff.getStaffRole();
	 

		Connection currentCon = null;
		 ResultSet rs = null; 
		 PreparedStatement ps=null;
		 Statement stmt=null;
	    
	    String userNameDB = "";
	    String passwordDB = "";
	    String roleDB = "";
	    
		
		try {
			// get connection from connection pool
			currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery("select staffUser,staffPassword,staffRole from staff");
            //ps = currentCon.prepareStatement(sql);
           

			// check if username and password matched any record
            while(rs.next())
            {
                userNameDB = rs.getString("staffUser");
                passwordDB =rs.getString("staffPassword");
                roleDB = rs.getString("staffRole");
     
                if(staffUser.equals(userNameDB) && staffPassword.equals(passwordDB) && roleDB.equals("MANAGER"))
                return "Manager_Role";
                
                else if(staffUser.equals(userNameDB) && staffPassword.equals(passwordDB) && roleDB.equals("STAFF"))
                return "Staff_Role";
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return "Invalid user credentials";
    }
	
	public Staff getStaff(Staff staff)  {

		id = staff.getStaffId();
        String searchQuery = "select * from staff where staffid='" + id + "'";

        try{
        	currentCon = ConnectionManager.getConnection();
        	stmt = currentCon.createStatement();
        	rs = stmt.executeQuery(searchQuery);
        	boolean more = rs.next();
        
        System.out.println(searchQuery);

        // if student exists set the isValid variable to true
        if (more) {
            staff.setValid(true);
       	}
       
        else if (!more) {            	
        	staff.setValid(false);
        }
       
    }

    catch (Exception ex) {
        System.out.println("Log In failed: An Exception has occurred! " + ex);
    }

    finally {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
            }
            rs = null;
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (Exception e) {
            }
            stmt = null;
        }

        if (currentCon != null) {
            try {
                currentCon.close();
            } catch (Exception e) {
            }

            currentCon = null;
        }
    }

    return staff;
}

	public void add(Staff staff) {
		
		  //id = staff.getStaffId();
	      username = staff.getStaffUser();
	      password=staff.getStaffPassword();
	      role=staff.getStaffRole();
	      managerId=staff.getManagerId();
	      status=staff.getStatus();
	       
	      try {
	    		currentCon = ConnectionManager.getConnection();
	    		ps=currentCon.prepareStatement("insert into staff (staffUser,staffPassword,staffRole,managerId,status)values(?,?,?,?,?)");
	    		//ps.setString(1,id);
	    		ps.setString(1,username);
	    		ps.setString(2,password);
	    		
	    		
	    		if (staff.getStaffRole().equals(""))
					ps.setString(3, staff.getStaffRole());
				else
					ps.setNull(3, java.sql.Types.INTEGER);

	    		
	    		if (staff.getManagerId() !="")
					ps.setString(4, staff.getManagerId());
				else
					ps.setNull(4, java.sql.Types.INTEGER);

				
	    		if (staff.getStatus()!="") {
					ps.setString(5, staff.getStatus());
	    			//ps.setInt(7, Integer.parseInt(fulltime.getFixedAllowance));
	    		}
				else
					ps.setNull(5, java.sql.Types.VARCHAR);

	    		
	    		ps.executeUpdate();
	    	
	    		System.out.println("Id is " + id);
				System.out.println("Name is " + username);
	    		System.out.println("Password is " + password);
	    		System.out.println("role is " + role);
	    		System.out.println("Manager is " + managerId);
	    		System.out.println("Status is " + status);
	            
	            
	            
	    	}

	    	catch (Exception ex) {
	    		System.out.println("failed: An Exception has occurred! " + ex);
	    	}

	    	finally {
	    		if (ps != null) {
	    			try {
	    				ps.close();
	    			} catch (Exception e) {
	    			}
	    			ps = null;
	    		}
	    		
	    		if (currentCon != null) {
	    			try {
	    				currentCon.close();
	    			} catch (Exception e) {
	    			}
	    			currentCon = null;
	    		}
	    	}
			
			
		}
		
    
	public List<Staff> getAllStaff() {

		// initialize an empty ArrayList
		List<Staff> staffs =  new ArrayList<Staff>();

		 try {
			  	currentCon = ConnectionManager.getConnection();
			  	stmt = currentCon.createStatement();
			  
			  	  String q = "select * from staff order by staffid";
			      ResultSet rs = stmt.executeQuery(q);
	          
			// loop for each record selected
			while (rs.next()) {
				
				Staff staff=new Staff();
				
				// get values for this record
				staff.setStaffId(rs.getString("staffId"));
				staff.setStaffUser(rs.getString("staffUser"));
				staff.setStaffPassword(rs.getString("staffPassword"));
				staff.setStaffRole(rs.getString("staffRole"));
				staff.setManagerId(rs.getString("managerId"));
				staff.setStatus(rs.getString("status"));

				
				/**if (managerId != "") {
					Staff manager = getStaff(managerId);
					emp.setManager(manager);
				}
				if (staff.getStatus()!= "") {
					staff.setStatus(rs.getString("status"));
				}
				else
					status.contentEquals("PART TIME");**/
				// add this Employee bean object to the ArrayList
				staffs.add(staff);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} 
		// return the ArrayList with list of Employee object
		return staffs;

	}

public Staff getStaffById(String id) {
		
		Staff staff = new Staff();
		
		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("select * from staff where staffid=?");

			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				staff.setStaffId(rs.getString("staffId"));
				staff.setStaffUser(rs.getString("staffUser"));
				staff.setStaffPassword(rs.getString("staffPassword"));
				staff.setStaffRole(rs.getString("staffRole"));
				staff.setManagerId(rs.getString("managerId"));
				staff.setStatus(rs.getString("status"));
			
				// set foreign key objects (good practice)
				
				/**if (staff.getStaffRole()!= "") {
					staff.setStaffRole(rs.getString("staffRole"));
				}
					
				if (staff.getManagerId() != "") {
					staff.setManagerId(rs.getString("managerId"));
				}
				
				if (staff.getStatus()!= "") {
					staff.setStatus(rs.getString("status"));
				}**/
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return staff;
	}
	
	public static List<String> getManagerName(){
		// initialize an empty ArrayList
		List<String> manager =  new ArrayList<String>();

		 try {
			  	currentCon = ConnectionManager.getConnection();
			  	stmt = currentCon.createStatement();
			  
			  	  String q = "select * from staff";
			      ResultSet rs = stmt.executeQuery(q);
	          
			// loop for each record selected
			while (rs.next()) {
				
				Staff staff=new Staff();
				String staffName;
				// get values for this record
				
				if(staff.getStaffRole().equals("MANAGER")) {
					staffName=rs.getString("staffUser");
								
				// add this Employee bean object to the ArrayList
				manager.add(staffName);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		// return the ArrayList with list of Employee object
		return manager;
		 
	
	} 

	
		
public void deleteStaff(String id) {
	String searchQuery = "delete from staff where staffid=" + "'" + id + "'";
	
	System.out.println(searchQuery);
	
	try {

        currentCon = ConnectionManager.getConnection();
        stmt = currentCon.createStatement();
        stmt.executeUpdate(searchQuery);
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
	
}
	public void updateStaff(Staff staff){

		  id = staff.getStaffId();
	      username = staff.getStaffUser();
	      password=staff.getStaffPassword();
	      role=staff.getStaffRole();
	      managerId=staff.getManagerId();
	      status=staff.getStatus();
	
	      String searchQuery = "UPDATE staff SET staffUser='" + username  + "' , staffPassword='" +password + "',staffRole='" + role  + "' ,managerId='" + managerId +"',status='" + status + "' WHERE staffid= '" + id + "'";
	      try {

				currentCon = ConnectionManager.getConnection();
				stmt = currentCon.createStatement();
				stmt.executeUpdate(searchQuery);

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		

	}