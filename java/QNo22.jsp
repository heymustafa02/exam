<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	if(age<18)
	{
		out.println("<p style='color:red;'>"+name+" is Not Eligible for Voting</p>");
	}
	else
	{
		out.println("<p style='color:green;'>"+name+" is Eligible for Voting</p>");
	}
%>
</body>
</html>