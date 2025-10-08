

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class sql
 */
@WebServlet("/add")
public class add extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		        int i = Integer.parseInt(request.getParameter("n1"));
		        int j = Integer.parseInt(request.getParameter("n2"));
		        int sum = i + j;

		        request.setAttribute("sum", sum);

		        // Forward to q5 servlet mapped as /q5
		        RequestDispatcher rd = request.getRequestDispatcher("/q5");
		        rd.forward(request, response);
		    }
		}












 