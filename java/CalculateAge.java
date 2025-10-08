

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Year;

/**
 * Servlet implementation class CalculateAge
 */
@WebServlet("/CalculateAge")
public class CalculateAge extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 // Get current year
        int currentYear = Year.now().getValue();

        // Read birth year from form
        int birthYear = Integer.parseInt(request.getParameter("birthYear"));

        // Calculate age
        int age = currentYear - birthYear;

        // Set age as attribute
        request.setAttribute("age", age);

        // Forward to DisplayCategory servlet
        RequestDispatcher rd = request.getRequestDispatcher("DisplayCategory");
        rd.forward(request, response);
    }
}
		
