

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QNo2
 */
public class QNo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
        PrintWriter out = res.getWriter();

        String rollno = req.getParameter("rollno");
        String name = req.getParameter("name");
        String subject = req.getParameter("subject");

        out.println("<html><body>");
        out.println("<h2>Student Info</h2>");
        out.println("<p>Roll No: " + rollno + "</p>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p><b>Selected Subject: " + subject + "</b></p>");
        out.println("</body></html>");
	}

}
