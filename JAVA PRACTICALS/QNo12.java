import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class QNo12
 */
public class QNo12 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		PrintWriter out = res.getWriter();
		int num = Integer.parseInt(req.getParameter("num"));
		for(int i = 1; i<=10; i++)
		{
			out.println(num + " x " + i + " = " +(num*i));
		}
	}

}
