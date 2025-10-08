import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class QNO5 
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
		Statement st = con.createStatement();
		String ctable= "CREATE TABLE "+tname+"("+fcol+" varchar(20), "+scol+" varchar(20), "+tcol+" varchar(20), " +ftcol+" int)";
		st.executeUpdate(ctable);
		System.out.println("***TABLE CREATED***");
		
		String[] code = new String[5];
		String[] name = new String[5];
		String[] department = new String[5];
		int[] number_of_students = new int[5];
		
		for(int i=0;i<5;i++)
		{
			System.out.println("ENTER DETAILS OF COURSE "+(i+1));
			System.out.println("Enter Course Code : ");
			code[i] = sc.next();
			System.out.println("Enter Course Name : ");
			name[i] = sc.next();
			System.out.println("Enter Course Department : ");
			department[i] = sc.next();
			System.out.println("Enter Number of Students : ");
			number_of_students[i] = sc.nextInt();
			String ivalue = "INSERT INTO "+tname+" VALUES('"+code[i]+"','"+name[i]+"','"+department[i]+"',"+number_of_students[i]+")";
			st.executeUpdate(ivalue);
			System.out.println("***VALUES INSERTED***");
		}
		
		System.out.println("UPDATE QUERY");
		System.out.println("Enter Department Name to Update : ");
		String dept = sc.next();
		System.out.println("Enter Number of Students : ");
		int newvalue = sc.nextInt();
		String uvalue = "UPDATE "+tname+" SET "+tcol+"='"+dept+"' WHERE "+ftcol+"="+newvalue;
		st.executeUpdate(uvalue);
		System.out.println("***VALUE UPDATE***");
		
		con.close();
		sc.close();
	}
}
