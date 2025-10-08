import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class QNO6 
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
		String ctable= "CREATE TABLE "+tname+"("+fcol+" int, "+scol+" varchar(20), "+tcol+" int, " +ftcol+" varchar(20)CHECK("+ftcol+" IN ('Male', 'Female'), "+fvcol+" varchar(20))";
		st.executeUpdate(ctable);
		System.out.println("***TABLE CREATED***");
		
		int[] srn = new int[5];
        String[] sname = new String[5];
        int[] sper = new int[5];
        String[] sgen = new String[5];
        String[] sclass = new String[5];

        for (int i = 0; i < 5; i++) 
        {
            System.out.println("ENTER DETAILS OF STUDENT " + (i + 1));
            System.out.println("Enter Student Roll Number: ");
            srn[i] = sc.nextInt();
            System.out.println("Enter Student Name: ");
            sname[i] = sc.next();
            System.out.println("Enter Student Percentage: ");
            sper[i] = sc.nextInt();
            System.out.println("Enter Student Gender (Male/Female): ");
            sgen[i] = sc.next();
            System.out.println("Enter Student Class: ");
            sclass[i] = sc.next();
            String ivalue = "INSERT INTO " + tname + " VALUES(" +srn[i] + ", '" + sname[i] + "', " + sper[i] + ", '" + sgen[i] + "', '" + sclass[i] + "')";
            st.executeUpdate(ivalue);
            System.out.println("***VALUES INSERTED***");
        }
        con.close();
		sc.close();
	}
}
