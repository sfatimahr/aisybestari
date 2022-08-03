package aisybestari.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import aisybestari.model.Enroll_Subject;
import aisybestari.connection.ConnectionManager;

public class Enroll_SubjectDAO {
	
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	static String enrollId, subjectId, slotId;
	static SlotDAO daoSlot;
	
	public Enroll_Subject getEnroll_Subject(Enroll_Subject enroll_subject) {
		enrollId = enroll_subject.getEnrollId();
		subjectId = enroll_subject.getSubjectId();
		slotId = enroll_subject.getSlotId();
		
		String searchQuery = "select * from enroll_subject where enrollId='" + enrollId +  "' and subjectId='" + subjectId  + "' and slotId='" + slotId + "'";
		
		try {
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();
            
            System.out.println(searchQuery);

            // if teacherSubject exists set the isValid variable to true
            if (more) {
            	enroll_subject.setValid(true);
           	}
           
            else if (!more) {
            	enroll_subject.setValid(false);
            }
           
        }

        catch (Exception ex) {
            System.out.println("An Exception has occurred! " + ex);
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

        return enroll_subject;
	}
	
	public Enroll_Subject add(String subjectId, String slotId) {
       
    	try {
    		currentCon = ConnectionManager.getConnection();
    		ps=currentCon.prepareStatement("insert into enroll_subject (enrollId, subjectId, slotId)values((select max(enrollId) from enrollment),?,?)");
    		//ps.setString(1, enrollId);
    		ps.setString(1, subjectId);
    		ps.setString(2, slotId);                           
    		ps.executeUpdate();
    	
    		System.out.println(enrollId + " has enrolled in " + slotId);            
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
		return null;				
	}
	
	public List<Enroll_Subject> getAllSlotsByEnrollment(String slotId) {
		  List<Enroll_Subject> enroll_subjects = new ArrayList<Enroll_Subject>();
		  
		  try {
		  	currentCon = ConnectionManager.getConnection();
		  	stmt = currentCon.createStatement();
		  
		  	String q = "select * from enroll_subject where slotId= '" + slotId + "'";
		  	System.out.println(q);
		    ResultSet rs = stmt.executeQuery(q);
		      
		      
		      while (rs.next()) {
		    	  Enroll_Subject enroll_subject = new Enroll_Subject();
		          
		    	  enroll_subject.setEnrollId(rs.getString("enrollId"));;
		    	  enroll_subject.setSubjectId(rs.getString("subjectId"));
		    	  enroll_subject.setSlotId(rs.getString("slotId"));
		    	  
		    	  enroll_subjects.add(enroll_subject);
		      }
		  } catch (SQLException e) {
		      e.printStackTrace();
		  }

		  return enroll_subjects;
	}	 
	
}
