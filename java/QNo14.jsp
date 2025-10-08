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
int num = Integer.parseInt(request.getParameter("n1"));
int sum = 0;
int rem;
while(num>0)
{
	rem = num%10;
	sum = sum+rem;
	num = num/10;
}
out.println("<p style='color:green;'>SUM OF DIGIT = " +sum+ "</p>");
%>
</body>
</html>