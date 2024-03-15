<%@page import="java.util.List"%>
<%@page import="student_servlet.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1 style="color:green">login successful</h1>
	<%
	List<Student> list=(List<Student>)request.getAttribute("list"); 
	for(Student s:list) {
	%>
	<p>***************</p>
	
	<p>Student Name: <%=s.getName() %></p>
	<p>Student Email: <%=s.getEmail()%></p>
	<p>Student Phno: <%=s.getPhno() %></p>
	<p>Student Gender: <%=s.getEmail()%></p>
	<button>Update</button>
	<a href="delete?email=<%s.getEmail();%>">
	<button>Delete</button>
	</a>
	<%}%> 
	
	
</body>
</html>