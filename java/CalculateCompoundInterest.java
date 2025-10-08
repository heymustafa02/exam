

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class CalculateCompoundInterest
 */
@WebServlet("/CalculateCompoundInterest")
public class CalculateCompoundInterest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        double principal = (double) request.getAttribute("principal");
        double rate = (double) request.getAttribute("rate");
        double time = (double) request.getAttribute("time");
        double simpleInterest = (double) request.getAttribute("simpleInterest");

        // Compound Interest: P * ( (1 + R/100)^T ) - P
        double amount = principal * Math.pow((1 + rate / 100), time);
        double compoundInterest = amount - principal;

        out.println("<h2>Interest Calculation Results</h2>");
        out.println("<p>Principal: " + principal + "</p>");
        out.println("<p>Rate: " + rate + "%</p>");
        out.println("<p>Time: " + time + " years</p>");
        out.println("<p>Simple Interest: " + String.format("%.2f", simpleInterest) + "</p>");
        out.println("<p>Compound Interest: " + String.format("%.2f", compoundInterest) + "</p>");
    }
}
	
