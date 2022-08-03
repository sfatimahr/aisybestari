package aisybestari.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import aisybestari.connection.ConnectionManager;
import aisybestari.model.Subject;

public class SubjectDAO {
	
	private Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	static String id, name, lvl, fee;
	
	public SubjectDAO(Connection con) {
		super();
		this.currentCon = con;
	}

	public Subject getSubject(Subject subject) {
		id = subject.getSubjectId();

        String searchQuery = "select * from subject where subjectid='" + id + "'";

        try {
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();
            
            System.out.println(searchQuery);

            // if subject exists set the isValid variable to true
            if (more) {
                subject.setValid(true);
           	}
           
            else if (!more) {            	
            	subject.setValid(false);
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

        return subject;
	}
	
	public void add(Subject subject) {
		
        name = subject.getSubjectName();
        lvl = subject.getLvl();
        fee = subject.getFee();        
       
    	try {
    		currentCon = ConnectionManager.getConnection();
    		ps=currentCon.prepareStatement("insert into subject (subjectname, lvl, fee)values(?,?,?)");
    		ps.setString(1,name);
    		ps.setString(2,lvl);
    		ps.setString(3, fee);
    		
    		ps.executeUpdate();
    	
    		System.out.println("Id is " + id);
			System.out.println("Name is " + name);
    		System.out.println("Level is " + lvl);
    		System.out.println("Fee is " + fee);
            
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

	public List<Subject> getAllSubject() {
		
		List<Subject> subjects = new ArrayList<Subject>();
		  
		  try {
		  	currentCon = ConnectionManager.getConnection();
		  	stmt = currentCon.createStatement();
		  
		  	  String q = "select * from subject order by subjectId";
		      ResultSet rs = stmt.executeQuery(q);
		      
		      while (rs.next()) {
		          Subject subject = new Subject();		          
		          
		          subject.setSubjectId(rs.getString("subjectid"));
		          subject.setSubjectName(rs.getString("subjectname"));
		          subject.setLvl(rs.getString("lvl"));
		          subject.setFee(rs.getString("fee"));
		          subjects.add(subject);
		      }
		  } catch (SQLException e) {
		      e.printStackTrace();
		  }
		  return subjects;
	}
	
	public void deleteSubject(String id) {
		String searchQuery = "delete from subject where subjectid=" + "'" + id + "'";
		
		System.out.println(searchQuery);
		
		try {
	
	        currentCon = ConnectionManager.getConnection();
	        stmt = currentCon.createStatement();
	        stmt.executeUpdate(searchQuery);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}
	
	public Subject getSubjectById(String id) {
		
		Subject subject = new Subject();
		
		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("select * from subject where subjectid=?");

			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				subject.setSubjectId(rs.getString("subjectid"));
				subject.setSubjectName(rs.getString("subjectname"));
				subject.setLvl(rs.getString("lvl"));
				subject.setFee(rs.getString("fee"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return subject;
	}
	
	public void updateSubject(Subject subject) {

		id = subject.getSubjectId();
		name = subject.getSubjectName();
		lvl = subject.getLvl();
		fee = subject.getFee();
		
		String searchQuery = "UPDATE subject SET subjectname='" + name  + "' , lvl='" + lvl + "' , fee='" + fee + "' WHERE subjectid= '" + id + "'";

		try {

			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			stmt.executeUpdate(searchQuery);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
}
