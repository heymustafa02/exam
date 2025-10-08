<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
    border-collapse: collapse;
    width: 50%;
    }
th, td {
    border: 1px solid black;
    padding: 8px;
    text-align: left;
   }
th {
    background-color: #f2f2f2;
   }
</style>
</head>
<body>
<%
		int rollno = Integer.parseInt(request.getParameter("rollno"));
		String name = request.getParameter("name");
        int m1 = Integer.parseInt(request.getParameter("m1"));
        int m2 = Integer.parseInt(request.getParameter("m2"));
        int m3 = Integer.parseInt(request.getParameter("m3"));
        int m4 = Integer.parseInt(request.getParameter("m4"));
        int m5 = Integer.parseInt(request.getParameter("m5"));
        int total = m1+m2+m3+m4+m5;
        float percentage = total/5;
        
        out.println("<h2>Student Result</h2>");
        out.println("<p><strong>Roll No:</strong> " + rollno + "</p>");
        out.println("<p><strong>Name:</strong> " + name + "</p>");

        out.println("<table>");
        out.println("<tr><th>Subject</th><th>Marks Obtained</th></tr>");
        out.println("<tr><td>DS</td><td>" + m1 + "</td></tr>");
        out.println("<tr><td>JDBC</td><td>" + m2 + "</td></tr>");
        out.println("<tr><td>JS</td><td>" + m3 + "</td></tr>");
        out.println("<tr><td>NS</td><td>" + m4 + "</td></tr>");
        out.println("<tr><td>React JS</td><td>" + m5 + "</td></tr>");
        out.println("<tr><td><strong>TOTAL</strong></td><td>" + total + "</td></tr>");
        out.println(String.format("<tr><td><strong>PERCENTAGE</strong></td><td>%.2f%%</td></tr>", percentage));
        out.println("</table>");
        
%>
</body>
</html>