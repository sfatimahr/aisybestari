package aisybestari.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import aisybestari.connection.ConnectionManager;
import aisybestari.model.Student;

public class StudentDAO {
	
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	static String id, name, age, address, contact, email, username, password;

	public Student getStudent(Student student) {
		id = student.getStudId();

        String searchQuery = "select * from student where studId='" + id + "'";

        try {
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();
            
            System.out.println(searchQuery);

            // if student exists set the isValid variable to true
            if (more) {
                student.setValid(true);
           	}
           
            else if (!more) {            	
            	student.setValid(false);
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

        return student;
	}
	
	public void add(Student student) {
		
        name = student.getStudName();
        age = student.getAge();
        address = student.getAddress();
        contact = student.getContact();
        email = student.getEmail();
        username = student.getStudUser();
        password = student.getStudPassword();
            
    	try {
    		currentCon = ConnectionManager.getConnection();
    		ps=currentCon.prepareStatement("insert into student (studName, age, address, contact, email, studUser, studPassword)values(?,?,?,?,?,?,?)");
    		ps.setString(1,name);
    		ps.setString(2,age);
    		ps.setString(3,address);
    		ps.setString(4,contact);
    		ps.setString(5,email);
    		ps.setString(6,username);
    		ps.setString(7,password);
			
    		ps.executeUpdate();
    	
    		System.out.println("Id is " + id);
			System.out.println("Name is " + name);
    		System.out.println("Age is " + age);
    		System.out.println("Address is " + address);
			System.out.println("Contact is " + contact);
    		System.out.println("Email is " + email);
    		System.out.println("Username is " + username);
    		System.out.println("Password is " + password);
            
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

	public List<Student> getAllStudent() {
		List<Student> students = new ArrayList<Student>();
		  
		  try {
		  	currentCon = ConnectionManager.getConnection();
		  	stmt = currentCon.createStatement();
		  
		  	  String q = "select * from student order by studId";
		      ResultSet rs = stmt.executeQuery(q);
		      
		      while (rs.next()) {
		          Student student = new Student();		          
		          
		          student.setStudId(rs.getString("studid"));
		          student.setStudName(rs.getString("studname"));
		          student.setAge(rs.getString("age"));
		          student.setAddress(rs.getString("address"));
		          student.setContact(rs.getString("contact"));
		          student.setEmail(rs.getString("email"));
		          students.add(student);
		      }
		  } catch (SQLException e) {
		      e.printStackTrace();
		  }

		  return students;
	}
	
	public Student getStudentById(String id) {
		
		Student student = new Student();
		
		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("select * from student where studId=?");

			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				student.setStudId(rs.getString("studid"));
				student.setStudName(rs.getString("studname"));
				student.setAge(rs.getString("age"));
				student.setAddress(rs.getString("address"));
				student.setContact(rs.getString("contact"));
				student.setEmail(rs.getString("email"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return student;
	}
	
	public void updateStudent(Student student) {

		id = student.getStudId(); 
		name = student.getStudName();
		age = student.getAge();
		address = student.getAddress();
		contact = student.getContact();
		email = student.getEmail();

		String searchQuery = "UPDATE student SET studName='" + name  + "' , age='" + age + "' , address='" + address + "' , contact='" + contact + "' , email='" + email + "' WHERE studId= '" + id + "'";

		try {

			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			stmt.executeUpdate(searchQuery);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	  public Student studLogin(String studUser, String studPassword) { 
	  Student student = new Student();
	  
	  try { 
		  currentCon = ConnectionManager.getConnection(); 
		  ps=currentCon.prepareStatement("select * from student where studUser=? and studPassword=?");
		  
		  ps.setString(1, studUser); 
		  ps.setString(2, studPassword); 
		  ResultSet rs = ps.executeQuery();
		  
		  if (rs.next()) { 
			  student.setStudId(rs.getString("studid"));
			  student.setStudName(rs.getString("studname"));
			  student.setAge(rs.getString("age"));
			  student.setAddress(rs.getString("address"));
			  student.setContact(rs.getString("contact"));
			  student.setEmail(rs.getString("email"));  
		  }
		  
	  } catch (SQLException e) { 
		  e.printStackTrace(); 
	  }
	  
	  return student; 
	  }
	  
	  public boolean validate(Student student) throws ClassNotFoundException {
	        boolean status = false;

	        try {

	        	currentCon = ConnectionManager.getConnection();
	            // Step 2:Create a statement using connection object
	            PreparedStatement ps = currentCon.prepareStatement("select * from student where studUser=? and studPassword=?");
	            ps.setString(1, student.getStudUser());
	            ps.setString(2, student.getStudPassword());

	            System.out.println(ps);
	            ResultSet rs = ps.executeQuery();
	            status = rs.next();

	        } catch (SQLException e) {
	        	 e.printStackTrace(); 
	        }
	        return status;
	  }

	
	
}
