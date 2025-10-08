
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class EmpServlet
 */
@WebServlet("/EmpServlet")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int eno = Integer.parseInt(request.getParameter("eno"));
		String ename = request.getParameter("ename");
		String birthdate = request.getParameter("birthdate");
		String bloodgroup = request.getParameter("bloodgroup");
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","root");
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO employee VALUES (?,?,?,?)");
			ps.setInt(1, eno);
			ps.setString(2,  ename);
			ps.setDate(3,  java.sql.Date.valueOf(birthdate));
			ps.setString(4,  bloodgroup);
			
			int i = ps.executeUpdate();
			
			if (i > 0) {
				out.println("<h3>Record Saved Successfully!</h3>");
			} else {
				out.println("<h3>Failed to Save Successfully!</h3>");
			}
					
		    con.close();	
		}catch (Exception e) {
			out.println("<h3>Error: " + e.getMessage() + "</h3>");
		}
				
	}

}


