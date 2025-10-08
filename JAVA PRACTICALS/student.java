

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class student
 */
@WebServlet("/student")
public class student extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = res.getWriter();
		   String roll = req.getParameter("roll");
		   String name = req.getParameter("name");
		   String subject = req.getParameter("subject");
		   
		   out.println("Student Information");
		   out.println("Roll No: " + roll);
		   out.println("Name: " + name);
		   out.println("Subject: " + subject);
		   
	}

}
