<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="personal" scope="request" class="com.np.mvc.PersonalBeanModel"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MVC First Try</title>
</head>
<body>
	Name : <jsp:getProperty name="personal" property="name"/>
	<br>
	Mail : <jsp:getProperty name="personal" property="mail"/>
</body>
</html>