

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class QNo4
 */
public class QNo4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		PrintWriter out = res.getWriter();

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String dob = req.getParameter("dob");
        String bg = req.getParameter("bg");

        try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/postgres","postgres","root");
			out.println("Connection Established");
			Statement st = con.createStatement();
			String ivalue = "INSERT INTO Employee_Servlet VALUES(" + id + ", '" + name + "', '" + dob + "', '" + bg + "')";
	        st.executeUpdate(ivalue);
	        out.println("***VALUES INSERTED***");
		}
        catch (Exception e)
        {
            out.println("Error: " + e.getMessage());
		}

	}
}
