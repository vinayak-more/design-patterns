package com.project.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.ManageUser;
import com.project.dao.User;

/**
 * Servlet implementation class NewRegister
 */
@WebServlet("/NewRegister")
public class NewRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("my new servlet reached");
		response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
         String name=request.getParameter("firstname");
         System.out.println(name);
         User user= new User();
         user.setName(request.getParameter("firstname"));
         user.setUsername(request.getParameter("username"));
         user.setEmail(request.getParameter("email"));
         user.setPassword(request.getParameter("password"));
         System.out.println(request.getParameter("dob"));
         String startDateString =request.getParameter("dob");
 	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
 	    try 
 	    {
 	        Date startDate =  df.parse(startDateString);
 	        user.setDob(startDate);
 	    }
 	    catch(Exception e)
 	    {
 	    	System.out.println("Date formatt exceptoin");
 	    	System.out.println(e);
 	    }
         user.setGender(request.getParameter("gender"));
         ManageUser entry=new ManageUser();
         
         if(entry.addRow(user))
         {
        	 out.print("<p style=\"color:blue\">entry successfull</p><br/> <a href=\"index.jsp\">Login</a>");  
         }
         else
         {
        	 out.print("<p style=\"color:red\">failed</p>");  
         }
		
		
		
	}

}
