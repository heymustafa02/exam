import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class QNO3 
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/postgres","postgres","root");
		System.out.println("Connection Established");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Table Name : ");
		String tname = sc.next();
		System.out.println("Enter 1st Column Name : ");
		String fcol = sc.next();
		System.out.println("Enter 2nd Column Name : ");
		String scol = sc.next();
		System.out.println("Enter 3rd Column Name : ");
		String tcol = sc.next();
		System.out.println("Enter 4th Column Name : ");
		String ftcol = sc.next();
		System.out.println("Enter 5th Column Name : ");
		String fvcol = sc.next();
		Statement st = con.createStatement();
		String ctable= "CREATE TABLE "+tname+"("+fcol+" int, "+scol+" varchar(20), "+tcol+" varchar(20) ,"+ftcol+" int ,"+fvcol+" int)";
		st.executeUpdate(ctable);
		System.out.println("***TABLE CREATED***");
		
		con.close();
		sc.close();
	}
}
