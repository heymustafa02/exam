

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class GradeDisplay
 */
@WebServlet("/GradeDisplay")
public class GradeDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        // Get total and percentage from request
	        int total = (int) request.getAttribute("total");
	        double percentage = (double) request.getAttribute("percentage");

	        // Determine grade
	        String grade;
	        if (percentage >= 90) grade = "A";
	        else if (percentage >= 75) grade = "B";
	        else if (percentage >= 60) grade = "C";
	        else if (percentage >= 50) grade = "D";
	        else grade = "F";

	        // Output
	        out.println("<h2>Student Result</h2>");
	        out.println("<p>Total Marks: " + total + " / 300</p>");
	        out.println("<p>Percentage: " + String.format("%.2f", percentage) + "%</p>");
	        out.println("<p>Grade: <strong>" + grade + "</strong></p>");
	    }
	}
