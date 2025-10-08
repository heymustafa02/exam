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
    int lastDigit = num % 10;

    int firstDigit = num;
    while (firstDigit >= 10) 
    {
       firstDigit /= 10;
    }

    int sum = firstDigit + lastDigit;
    out.println("<p style='color:red;'>SUM OF DIGIT = " +sum+ "</p>");
%>
</body>
</html>