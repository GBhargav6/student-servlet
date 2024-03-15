<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String msg=(String)request.getAttribute("msg");// getAttribute() is used to Retrive the data from databse with in the servlet context,request/session scope
	if (msg!=null) { %>                             
	<h1 style="color:red;">
	<%=msg%>
	</h1>
	<%}%>
	<form action="login">
		Email: <input typre="email" name="email" placeholder="Enter Email"><br><br>
		Password: <input type="password" name="password" placeholder="Enter password"><br><br>
		<input type="submit" value="login" style="margin-left: 50px;">
	</form>
	
</body>
</html>