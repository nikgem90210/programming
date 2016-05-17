<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="org.nishant.dto.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
</head>
<body>

<h2> Login Successful </h2>

<jsp:useBean id="user" class="org.nishant.dto.User" scope="request">
	<jsp:setProperty property="userName" name="user" value="NewUser"/>
</jsp:useBean>

Hello <jsp:getProperty property="userName" name="user"/>

</body>
</html>