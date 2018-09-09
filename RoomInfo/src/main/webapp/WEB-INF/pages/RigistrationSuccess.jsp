<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
    
   <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Room Registration Success for ${roomPerson} </h3>

<br>
<h4>All Room Users List</h4>
 <table border="1">
 
            <th>First Name</th>
            <th>Last name</th>
            <th>Email</th>
            <th>Password</th>
           
<c:forEach var="roomRegistration" items="${usersList}">
                <tr>
 
                    <td>${roomRegistration.firstName}</td>
                    <td>${roomRegistration.lastName}</td>
                    <td>${roomRegistration.email}</td>
                    <td>${roomRegistration.password}</td>
                    
 
                </tr>
            </c:forEach> 
           </table>
           
          <br>
          
          <a href="/SpringMVCHibernateProj">Go To Home page</a>
</body>
</html>