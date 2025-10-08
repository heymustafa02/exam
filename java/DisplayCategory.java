

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class DisplayCategory
 */
@WebServlet("/DisplayCategory")
public class DisplayCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get age from request
        int age = (int) request.getAttribute("age");

        // Determine category
        String category;
        if (age <= 12) {
            category = "Child";
        } else if (age <= 19) {
            category = "Teen";
        } else if (age <= 59) {
            category = "Adult";
        } else {
            category = "Senior";
        }

        // Output result
        out.println("<h2>Your Age Category</h2>");
        out.println("<p>Age: " + age + "</p>");
        out.println("<p>Category: <strong>" + category + "</strong></p>");
    }
}

		

