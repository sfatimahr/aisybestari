package aisybestari.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import aisybestari.connection.ConnectionManager;
import aisybestari.model.Slot;
import aisybestari.model.Subject;
import aisybestari.model.Cart;

public class SlotDAO {
	
	private Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	static String id, time, day, seat, subjectId;
	static SubjectDAO daoSubject; 
	static Enroll_SubjectDAO daoEnroll_Subject;
	
	public SlotDAO(Connection con) {
		super();
		this.currentCon = con;
	}
	
	public Slot getSlot(Slot slot) {
		id = slot.getSlotId();
		subjectId = slot.getSubjectId();

        String searchQuery = "select * from slot where slotid='" + id + "' and subjectId = '" + subjectId +"'";

        try {
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();
            
            System.out.println(searchQuery);

            // if slot exists set the isValid variable to true
            if (more) {
                slot.setValid(true);
           	}
           
            else if (!more) {            	
            	slot.setValid(false);
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

        return slot;
	}
	
	public void add(Slot slot) {
		
        time = slot.getSlotTime();
        day = slot.getSlotDay();
        seat = slot.getSlotSeat();
        subjectId = slot.getSubjectId();
        
    	List<Subject> subjects = daoSubject.getAllSubject();
    	setAttribute("subjects", subjects);
       
    	try {
    		currentCon = ConnectionManager.getConnection();
    		ps=currentCon.prepareStatement("insert into slot (slotTime, slotDay, slotSeat, subjectId)values(?,?,?,?)");
    		ps.setString(1, time);
    		ps.setString(2, day);
    		ps.setString(3, seat);
    		ps.setString(4, subjectId);
    		
    		ps.executeUpdate();
    		
    		System.out.println("Id is " + id);
			System.out.println("Time is " + time);
    		System.out.println("Day is " + day);
    		System.out.println("Seat is " + seat);
    		System.out.println("Subject is " + subjectId);    		
            
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
	
	private void setAttribute(String string, List<Subject> subjects) {

		
	}

	public List<Slot> getAllSlot() {
		List<Slot> slots = new ArrayList<Slot>();
		daoSubject = new SubjectDAO(null);
		Subject subject = new Subject();
		  
		  try {
		  	currentCon = ConnectionManager.getConnection();
		  	stmt = currentCon.createStatement();
		  
		  	  String q = "select * from slot order by slotId";
		  	  System.out.println(q);
		      ResultSet rs = stmt.executeQuery(q);
		      
		      while (rs.next()) {
		          Slot slot = new Slot();		          
		          
		          slot.setSlotId(rs.getString("slotId"));
		          slot.setSlotTime(rs.getString("slotTime"));
		          slot.setSlotDay(rs.getString("slotDay"));
		          slot.setSlotSeat(rs.getString("slotSeat"));
		          
		          subject = daoSubject.getSubjectById(rs.getString("subjectId"));
		          slot.setSubjectId(subject.getSubjectId());
		          slot.setSubjectName(subject.getSubjectName());
		          slot.setLvl(subject.getLvl());
		          slot.setFee(subject.getFee());
		          
		          slots.add(slot);
		      }
		  } catch (SQLException e) {
		      e.printStackTrace();
		  }

		  return slots;
	}
	
	public void deleteSlot(String id) {
		String searchQuery = "delete from slot where slotId=" + "'" + id + "'";
		
		System.out.println(searchQuery);
		
		try {
	
	        currentCon = ConnectionManager.getConnection();
	        stmt = currentCon.createStatement();
	        stmt.executeUpdate(searchQuery);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}
	
	public Slot getSlotById(String id) {
		Subject subject = new Subject();
		Slot slot = new Slot();
		
		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("select * from slot where slotId=?");

			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				slot.setSlotId(rs.getString("slotId"));
				slot.setSlotTime(rs.getString("slotTime"));
				slot.setSlotDay(rs.getString("slotDay"));
				slot.setSlotSeat(rs.getString("slotSeat"));

				subject = daoSubject.getSubjectById(rs.getString("subjectId"));
		        slot.setSubjectName(subject.getSubjectName() + " " + subject.getLvl());
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return slot;
	}
	
	public void updateSlot(Slot slot) {

		id = slot.getSlotId();
		time = slot.getSlotTime();
        day = slot.getSlotDay();
        seat = slot.getSlotSeat(); 
        subjectId = slot.getSubjectId();
		
		String searchQuery = "UPDATE slot SET slotTime='" + time  + "' , slotDay='" 
		+ day + "' , slotSeat='" + seat + "' , subjectId = '" + subjectId 
		+ "' WHERE slotId= '" + id + "'";

		try {

			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			stmt.executeUpdate(searchQuery);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public List<Cart> getCartSlots(ArrayList<Cart> cartList) {
        List<Cart> slots = new ArrayList<>();
        try {
            if (cartList.size() > 0) {
                for (Cart item : cartList) {
                    String query = "select * from products where id=?";
                    ps = currentCon.prepareStatement(query);
                    ps.setString(1, item.getSlotId());
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        Cart row = new Cart();
                        row.setSlotId(rs.getString("slotId"));
                        row.setSlotTime(rs.getString("slotTime"));
                        row.setSlotDay(rs.getString("slotDay"));
                        row.setLvl(rs.getString("lvl"));
                        row.setFee(rs.getString("fee"));
                        slots.add(row);
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return slots;
    }
	
	
}
