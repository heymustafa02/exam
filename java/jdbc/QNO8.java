import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class QNO8 
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/postgres","postgres","root");
		System.out.println("Connection Established");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM College228");
		System.out.println(" CID " + "\t" + " CName " + "\t" + " addr ");
		System.out.println("------------------------------------------");
		while(rs.next())
		{
			System.out.println(rs.getInt(1) +"\t"+ rs.getString(2) +"\t"+ rs.getString(3));
		}
		con.close();
	}
}