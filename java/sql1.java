

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class q5
 */
@WebServlet("/q5")
public class sql1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		        response.setContentType("text/html");
		        PrintWriter out = response.getWriter();

		        // Correctly cast attribute to Integer before unboxing
		        Integer sum = (Integer) request.getAttribute("sum");
		        if (sum == null) {
		            out.println("<h3>Error: sum attribute not found!</h3>");
		            return;
		        }
		        int product = sum * 2;

		        out.println("<h3>Sum: " + sum + "</h3>");
		        out.println("<h3>Product (sum * 2): " + product + "</h3>");
		    }
		}

	


