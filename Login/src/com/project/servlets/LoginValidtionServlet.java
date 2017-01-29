package com.project.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.dao.LoginDao;
import com.project.dao.LoginORM;

/**
 * Servlet implementation class LoginValidtionServlet
 */

public class LoginValidtionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginValidtionServlet() {
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
		System.out.println("888888888888888888reached servlet");
	       response.setContentType("text/html");  
	        PrintWriter out = response.getWriter();  
	        
	        String n=request.getParameter("username");  
	        String p=request.getParameter("userpass"); 
	        
	        HttpSession session = request.getSession(false);
	        if(session!=null)
	        session.setAttribute("name", n);

	        if(LoginORM.validate(n,p)){  
	            RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");  
	            rd.forward(request,response);  
	        }  
	        else{  
	            out.print("<p style=\"color:red\">Sorry username or password error</p>");  
	            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
	            rd.include(request,response);  
	        }  

	        out.close();  
	}

}
