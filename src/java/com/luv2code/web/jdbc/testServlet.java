/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luv2code.web.jdbc;

import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;



/**
 *
 * @author max
 */
@WebServlet(name = "TestServlet", urlPatterns = {"/TestServlet"})
public class testServlet extends HttpServlet {

//define datasource/connection pool for resource injection
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
      static final String DB_URL="jdbc:mysql://localhost:3306/web_student_tracker";
      static final String USER = "webstudent";
      static final String PASS = "webstudent";


  
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Step 1: Set up the printwriter
        PrintWriter out = response.getWriter();
        response.setContentType("text/plain;charset=UTF-8");
        //Step 2: Get a connection to the database
        Connection conn=null;
        Statement myStmt=null;
        ResultSet myRs=null;
        
        try{
           Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);


            //Step 3: Create a SQL query
            String sql="select*from student";
            myStmt=(Statement) conn.createStatement();
            //Step 4: Execute SQL query
            myRs=myStmt.executeQuery(sql);
            //Step 5: Process the result set
            while(myRs.next()){
                String email = myRs.getString("email");
                out.println(email);
            }
            
        }
        catch(Exception exc){
            exc.printStackTrace();
        }
    }
 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

