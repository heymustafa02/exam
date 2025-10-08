

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class CalculatePercentage
 */
@WebServlet("/CalculatePercentage")
public class CalculatePercentage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		    
		    int sub1 = Integer.parseInt(request.getParameter("sub1"));
	        int sub2 = Integer.parseInt(request.getParameter("sub2"));
	        int sub3 = Integer.parseInt(request.getParameter("sub3"));

	        // Calculate total and percentage
	        int totalObtained = sub1 + sub2 + sub3;
	        int totalMax = 300;  // assuming 100 per subject
	        double percentage = (totalObtained * 100.0) / totalMax;

	        // Set values as request attributes
	        request.setAttribute("total", totalObtained);
	        request.setAttribute("percentage", percentage);

	        // Forward to GradeDisplay servlet
	        RequestDispatcher rd = request.getRequestDispatcher("GradeDisplay");
	        rd.forward(request, response);
    }
}
