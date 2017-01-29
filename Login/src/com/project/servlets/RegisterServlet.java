package com.project.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.Student;
import com.project.dao.StudentDao;


/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        String studentName = (String) request.getParameter("student_name");
        String email = (String) request.getParameter("email");
        String mobileNo = (String) request.getParameter("mobile_no");
        String address = (String) request.getParameter("address");
        Student st = new Student(studentName, email, mobileNo, address);
        boolean b = new StudentDao().save(st);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if (b) {
            out.print("<p style=\"color:blue\">entry successfull</p><br/> <a href=\"index.jsp\">Login</a>");
        } else {
            out.print("<p style=\"color:red\">failed</p>");
        }

    }

}
