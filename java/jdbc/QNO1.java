import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class QNO1 
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
		Statement st = con.createStatement();
		String ctable= "CREATE TABLE "+tname+"("+fcol+" int, "+scol+" varchar(20), "+tcol+" int)";
		st.executeUpdate(ctable);
		System.out.println("***TABLE CREATED***");
		
		int[] srn = new int[5];
		String[] sname = new String[5];
		int[] smarks = new int[5];
		
		for(int i=0;i<5;i++)
		{
			System.out.println("ENTER DETAILS OF STUDENT "+(i+1));
			System.out.println("Enter Student Number : ");
			srn[i] = sc.nextInt();
			System.out.println("Enter Student Name : ");
			sname[i] = sc.next();
			System.out.println("Enter Student Marks : ");
			smarks[i] = sc.nextInt();
			String ivalue = "INSERT INTO "+tname+" VALUES("+srn[i]+",'"+sname[i]+"',"+smarks[i]+")";
			st.executeUpdate(ivalue);
			System.out.println("***VALUES INSERTED***");
		}
		
		System.out.println("UPDATE QUERY");
		System.out.println("Enter Student Name to Update : ");
		String oldname = sc.next();
		System.out.println("Enter New Student Name : ");
		String newname = sc.next();
		String uvalue = "UPDATE "+tname+" SET "+scol+"='"+newname+"' WHERE "+scol+"='"+oldname+"'";
		st.executeUpdate(uvalue);
		System.out.println("***VALUE UPDATE***");
		
		System.out.println("DELETE QUERY");
		System.out.println("Enter Student Name to Delete : ");
		String dname = sc.next();
		String dvalue = "DELETE FROM "+tname+" WHERE "+scol+"='"+dname+"'";
		st.executeUpdate(dvalue);
		System.out.println("***VALUE DELETED***");
		
		con.close();
		sc.close();
	}
}
