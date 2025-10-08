

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class CalculateSimpleInterest
 */
@WebServlet("/CalculateSimpleInterest")
public class CalculateSimpleInterest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		double principal = Double.parseDouble(request.getParameter("principal"));
        double rate = Double.parseDouble(request.getParameter("rate"));
        double time = Double.parseDouble(request.getParameter("time"));

        // Simple Interest: (P × R × T) / 100
        double simpleInterest = (principal * rate * time) / 100;

        // Set attributes to forward
        request.setAttribute("principal", principal);
        request.setAttribute("rate", rate);
        request.setAttribute("time", time);
        request.setAttribute("simpleInterest", simpleInterest);

        // Forward to CompoundInterest servlet
        RequestDispatcher rd = request.getRequestDispatcher("CalculateCompoundInterest");
        rd.forward(request, response);
    }
}

