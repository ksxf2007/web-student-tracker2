/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luv2code.web.jdbc;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author max
 */
@WebServlet(name = "StudentControllerServlet", urlPatterns = {"/StudentControllerServlet"})
public class StudentControllerServlet extends HttpServlet {
    
 

   
     
     

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
        //list the students ... in MVC fashion
        listStudents(request, response);
        }
        catch(Exception exc){
            throw new ServletException(exc);
        }
       
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
 

    private void listStudents(HttpServletRequest request, HttpServletResponse response) 
    throws Exception {
	
		Client client=new Client();
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		client.setFirstName(firstName);
		client.setLastName(lastName);
		HttpSession session=request.getSession(true);
		session.setAttribute("client",client);
		
		
        // get students from db 
        List<Student> students=StudentDbUtil.getStudents();
		
		
        
        // add students to the request
        request.setAttribute("STUDENT_LIST", students);
        //send to JSP page (view)
        RequestDispatcher dispatcher= request.getRequestDispatcher("/list-students.jsp");
        dispatcher.forward(request,response);
    }

}
