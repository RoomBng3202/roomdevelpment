<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Contact</title>
</head>
<body>
    <div align="center">
        <h1>New ROOM PERSON Registration</h1>
        <form:form action="/SpringMVCHibernateProj/room/registrationProcess" method="post" modelAttribute="roomRegistrationForm">
        <table>
            <%-- <form:hidden path="id"/> --%>
            <tr>
                <td>First Name:</td>
                <td><form:input path="firstName" /></td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td><form:input path="lastName" /></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><form:input path="email" /></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><form:input path="password" type="password"/></td>
            </tr>
            <tr>
                <td>Confirm Password:</td>
                <td><form:input path="confirmPassword" type="password"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Registration">
                
                </td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>