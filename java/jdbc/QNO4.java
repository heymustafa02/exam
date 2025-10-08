import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class QNO4 
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/postgres","postgres","root");
		System.out.println("Connection Established");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Table Name : ");
		String tbname = sc.next();
		System.out.println("Enter 1st Column Name : ");
		String fcol = sc.next();
		System.out.println("Enter 2nd Column Name : ");
		String scol = sc.next();
		System.out.println("Enter 3rd Column Name : ");
		String tcol = sc.next();
		System.out.println("Enter 4th Column Name : ");
		String ftcol = sc.next();
		Statement st = con.createStatement();
		String ctable= "CREATE TABLE "+tbname+"("+fcol+" int, "+scol+" varchar(20), "+tcol+" int, " +ftcol+" varchar(20))";
		st.executeUpdate(ctable);
		System.out.println("***TABLE CREATED***");
		
		int[] tno = new int[5];
		String[] tname = new String[5];
		int[] sal = new int[5];
		String[] desg = new String[5];
		
		for(int i=0;i<5;i++)
		{
			System.out.println("ENTER DETAILS OF TEACHER "+(i+1));
			System.out.println("Enter Teacher Number : ");
			tno[i] = sc.nextInt();
			System.out.println("Enter Teacher Name : ");
			tname[i] = sc.next();
			System.out.println("Enter Teacher Sal : ");
			sal[i] = sc.nextInt();
			System.out.println("Enter Teacher Designation : ");
			desg[i] = sc.next();
			String ivalue = "INSERT INTO "+tbname+" VALUES("+tno[i]+",'"+tname[i]+"',"+sal[i]+",'"+desg[i]+"')";
			st.executeUpdate(ivalue);
			System.out.println("***VALUES INSERTED***");
		}
		con.close();
		sc.close();
	}
}
