/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luv2code.web.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author max
 */
public class StudentDbUtil {
    public static List<Student> getStudents() throws Exception{
        List<Student> students = new ArrayList<>();
        
        Connection myConn=null;
        Statement myStmt=null;
        ResultSet myRs=null;
        String DB_URL="jdbc:derby://localhost:1527/XiaofanXu";
        String USER = "IS2560";
        String PASS = "IS2560";
       
        try{
        //get a connecction
     
          Class.forName("org.apache.derby.jdbc.ClientDriver");
          myConn = DriverManager.getConnection(DB_URL, USER, PASS);
        //create sql statement
        String sql = "select * from student order by last_name";
        myStmt = (Statement)myConn.createStatement();
        //execute query
        myRs = myStmt.executeQuery(sql);
        //process result set
        while(myRs.next()){
            //retrieve data from result set row
            int id = myRs.getInt("id");
            String firstName= myRs.getString("FIRST_NAME");
            String lastName=myRs.getString("LAST_NAME");
            String email=myRs.getString("EMAIL");
            
            //create new student object
            Student tempStudent = new Student(id, firstName, lastName, email);
           
            //add it to the list of students
            students.add(tempStudent);
            
        }
        myStmt.close();
        myConn.close();
        myRs.close();
        }
         catch(Exception exc){
            System.out.println("Connect failed!");
        }
        //close JDBC objects
        return students;
        }
       
        }

   

    
