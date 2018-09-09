<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isELIgnored="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Welcome to login Page </h2>

<c:out value="${LoginFailed}" />
<form:form method="POST" commandName="loginForm" action="/SpringMVCHibernateProj/loginAccess">
	
	Email :<form:input path="userName"/><br>
	Password  :<form:password path="password"/><br>
	
	<input type="submit" value="Login">

</form:form>

</body>
</html>