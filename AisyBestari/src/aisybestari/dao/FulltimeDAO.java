package aisybestari.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import aisybestari.connection.ConnectionManager;
import aisybestari.model.Fulltime;
import aisybestari.model.Staff;

public class FulltimeDAO {
	
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	static String id;
	static String fixedAllowance;

	public void add(Fulltime fulltime) throws NoSuchAlgorithmException{

		//id = fulltime.getStaffId();
		fixedAllowance = fulltime.getFixedAllowance();        

		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("insert into fulltime (fixedAllowance)values(?)");
			//ps.setString(1,id);
			ps.setString(2,fixedAllowance);
			ps.executeUpdate();

			System.out.println("Your id is " + id);
			System.out.println("Your fixedAllowance is " + fixedAllowance);

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

	public Fulltime getFulltimebyId(Staff staff) {
		Fulltime fulltime = new Fulltime();		
		
		id = staff.getStaffId();
			
		String searchQuery = "select * from fulltime where staffid='" + id + "'";

        try {
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();
            
            if (more) {
            	fulltime.setStaffId(staff.getStaffId());
            	fulltime.setStaffUser(staff.getStaffUser());
            	fulltime.setStaffPassword(staff.getStaffPassword());
            	fulltime.setStaffRole(staff.getStaffRole());
            	fulltime.setManagerId(staff.getManagerId());
            	fulltime.setStatus(staff.getStatus());
	        	fulltime.setFixedAllowance(rs.getString("fixedAllowance"));
           	}
           
            else if (!more) {
            	System.out.println("Sorry");
            }
           
        }catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return fulltime;
	}

	public void updateFulltime(Fulltime fulltime) {
		id = fulltime.getStaffId();
		fixedAllowance = fulltime.getFixedAllowance();        

		String searchQuery = "UPDATE fulltime SET fixedallowance='" + fixedAllowance + "' WHERE staffid= '" + id + "'";

		try {

			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			stmt.executeUpdate(searchQuery);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void deleteFulltime(String id) {
		
		String searchQuery = "delete from fulltime where staffid=" + id;
		
		try {
	
	        currentCon = ConnectionManager.getConnection();
	        stmt = currentCon.createStatement();
	        stmt.executeUpdate(searchQuery);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}

}
