package com.jwt.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;

import com.jwt.dao.UserDAO;
	
	public class UserControllerServlet extends HttpServlet {
	     
	    private static final long serialVersionUID = 102831973239L;
	    Logger logger =Logger.getLogger(getClass().getName());
	    
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			
			//response.getWriter().append("Served at: ").append(request.getContextPath());
	    	response.setContentType("text/html");
	    	response.getWriter().println("<html><body><h3>Hello</h3></body></html>");
			PrintWriter writer = response.getWriter();
		
			
	        writer.println("" + "" + "<center>"
	                + "Details Added Successfully" + "</center>" + ""
	                + "");
		}
	 
	    protected void doPost(HttpServletRequest request,
	            HttpServletResponse response) throws ServletException, IOException {
	 
	        String name = request.getParameter("name");
	        String address = request.getParameter("address");
	        String phone = request.getParameter("phone");
	        String email = request.getParameter("email");
	        String exp = request.getParameter("exp");
	 
	        try {
	        	logger.info(">>>>> before exception");
	            UserDAO userDAO = new UserDAO();
	            userDAO.addUserDetails(name, address, phone, email, exp);
	            doGet(request, response);
	           // response.setContentType("text/html");
		    	//response.getWriter().println("<html><body><h3>Hello</h3></body></html>");
	        } catch (Exception e) {
	 
	            e.printStackTrace();
        }
           
	    	
    }
}
