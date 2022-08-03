package aisybestari.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import aisybestari.connection.ConnectionManager;
import aisybestari.model.Enrollment;
import aisybestari.model.Student;

public class EnrollmentDAO {

	private Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	static String id, date, status, staff, student, totalPayment;
	static StudentDAO daoStudent; 
	
	public EnrollmentDAO(Connection con) {
		super();
		this.currentCon = con;
	}
	
	public Enrollment getEnroll(Enrollment enrollment) {
		id = enrollment.getEnrollId();
		date = enrollment.getEnrollDate();
		status = enrollment.getEnrollStatus();
		staff = enrollment.getStaffId();
		student = enrollment.getStudId();		
		totalPayment = enrollment.getTotalPayment();
		
		String searchQuery = "select * from enrollment where enrollId='" + id + "' and studId = '" + student +"' and staffId = '" + staff + "'";
		
		try {
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();
            
            System.out.println(searchQuery);

            // if enrollment exists set the isValid variable to true
            if (more) {
                enrollment.setValid(true);
           	}
           
            else if (!more) {            	
            	enrollment.setValid(false);
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

        return enrollment;
	}
	
	public void add(Enrollment enrollment) {

    	try {
    		
    		currentCon = ConnectionManager.getConnection();
    		ps=currentCon.prepareStatement("insert into enrollment (studId) values ((select max(studId) from student))");
			
    		ps.executeUpdate();
    		
    		System.out.println("Student's enrolled");

            
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
	
	public List<Enrollment> getAllEnrollment() {
		List<Enrollment> enrollments = new ArrayList<Enrollment>();
		daoStudent = new StudentDAO();
		Student student = new Student();
		  
		  try {
		  	currentCon = ConnectionManager.getConnection();
		  	stmt = currentCon.createStatement();
		  
		  	  String q = "select * from enrollment order by enrollId";
		  	  System.out.println(q);
		      ResultSet rs = stmt.executeQuery(q);
		      
		      while (rs.next()) {
		          Enrollment enroll = new Enrollment();		          
		          
		          enroll.setEnrollId(rs.getString("enrollId"));
		          enroll.setEnrollDate(rs.getString("enrollDate"));
		          enroll.setEnrollStatus(rs.getString("enrollStatus"));
		          
		          enroll.setStaffId(rs.getString("staffId"));
		          enroll.setTotalPayment(rs.getString("totalPayment"));
		          
		          student = daoStudent.getStudentById(rs.getString("studId"));
		          enroll.setStudName(student.getStudName());
		          
		          enrollments.add(enroll);
		      }
		  } catch (SQLException e) {
		      e.printStackTrace();
		  }

		  return enrollments;
	}
	
	public Enrollment getEnrollmentById(String id) {
		Enrollment enrollment = new Enrollment();
		
		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("select * from enrollment where enrollId=?");

			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				enrollment.setEnrollId(rs.getString("enrollId"));
				enrollment.setEnrollDate(rs.getString("enrollDate"));
				enrollment.setEnrollStatus(rs.getString("enrollStatus"));
				enrollment.setStudId(rs.getString("studId"));
				enrollment.setStaffId(rs.getString("staffId"));
				enrollment.setTotalPayment(rs.getString("totalPayment"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return enrollment;
	}
	
	public void updateEnrollment(Enrollment enrollment) {
		
		daoStudent = new StudentDAO();
		Student student = new Student();
		
		id = enrollment.getEnrollId();
		status = enrollment.getEnrollStatus();
		staff = enrollment.getStaffId();	
		totalPayment = enrollment.getTotalPayment();
		
		String searchQuery = "UPDATE enrollment SET enrollStatus='" + status  + "' , staffId='" + staff + "' , totalPayment='" + totalPayment + "' WHERE enrollId= '" + id + "'";

		try {

			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			stmt.executeUpdate(searchQuery);
			
			while (rs.next()) {
				Enrollment enroll = new Enrollment();		
				
				student = daoStudent.getStudentById(rs.getString("studId"));
				enroll.setStudName(student.getStudName());
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
}
