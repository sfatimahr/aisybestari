package aisybestari.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aisybestari.model.Cart;

/**
 * Servlet implementation class SlotConfirmationController
 */
@WebServlet("/SlotConfirmationController")
public class SlotConfirmationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            ArrayList<Cart> cartList = new ArrayList<>();
            String id = request.getParameter("id");
            Cart cm = new Cart();
            cm.setSlotId(id);
            cm.setQuantity(1);
            HttpSession session = request.getSession();
            ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("confirmSlot");
            
            if (cart_list == null) {
                cartList.add(cm);
                session.setAttribute("confirmSlot", cartList);
                response.sendRedirect("pickSlot.jsp");
            } else {
            	cartList = cart_list;            	
            	boolean exist = false;
            	
            	for (Cart c : cart_list) { 
            		if (c.getSlotId().equals(id)) { 
            			exist = true;
                        out.println("<h3 style='color:crimson; text-align: center'>Item Already in Cart. <a href='cart.jsp'>GO to Cart Page</a></h3>");
                    }
                }

                if (!exist) {
                    cartList.add(cm);
                    response.sendRedirect("pickSlot.jsp");
                }
				 
            }
	}

	}

}
