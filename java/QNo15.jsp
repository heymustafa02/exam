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
int org = num;
int flag=0;
for(int i=2; i<num; i++)
{
	if(num%i == 0)
	{
		flag = 1;
		break;
	}
}
if(flag==1)
{
	out.println("<p style='color:red;'>"+org+" is Not a Prime Number</p>");
}
else
{
	out.println("<p style='color:green;'>"+org+" is a Prime Number</p>");
}

%>
</body>
</html>