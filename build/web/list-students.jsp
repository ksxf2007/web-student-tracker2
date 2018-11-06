<%-- 
    Document   : list-students
    Created on : Nov 3, 2018, 9:35:56 AM
    Author     : max
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.luv2code.web.jdbc.*"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Tracker App</title>
    </head>
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <%
        //get the students ffrom the request object( sent by servlet)
        List<Student> theStudents=(List<Student>) request.getAttribute("STUDENT_LIST");
        Client name=(Client)session.getAttribute("client");
        %>
    <body>
	
	    
		
	<h3> Hello <%=name.getFirstName() %> <%=name.getLastName()%>	
        
        <div id=""wrapper">
             <div id="header">
                 <h2>University of Pittsburgh</h2>
            </div>
        </div>
        
        <div id="container">
            <div id="content">
                <table>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email Name</th>
                    </tr>
                    <% for (Student tempStudent :theStudents){%>
                        <tr>
                            <td><%=tempStudent.getFirstName()%></td>
                            <td><%=tempStudent.getLastName()%></td>
                            <td><%=tempStudent.getEmail()%></td>
                        </tr>
                    <% }%>
                </table>
            </div>
   
    </body>
</html>
