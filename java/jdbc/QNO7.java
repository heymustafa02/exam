import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class QNO7 
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
		String ctable= "CREATE TABLE "+tname+"("+fcol+" int, "+scol+" varchar(20), "+tcol+" float)";
		st.executeUpdate(ctable);
		System.out.println("***TABLE CREATED***");
		
		int[] eno = new int[5];
        String[] ename = new String[5];
        float[] salary = new float[5];
        
        for (int i = 0; i < 5; i++) 
        {
            System.out.println("ENTER DETAILS OF EMPLOYEE " + (i + 1));
            System.out.println("Enter Employee Number: ");
            eno[i] = sc.nextInt();
            System.out.println("Enter Employee Name: ");
            ename[i] = sc.next();
            System.out.println("Enter Employee Salary: ");
            salary[i] = sc.nextFloat();
            String ivalue = "INSERT INTO " + tname + " VALUES(" +eno[i] + ", '" + ename[i] + "', " + salary[i] + ")";
            st.executeUpdate(ivalue);
            System.out.println("***VALUES INSERTED***");
        }
        con.close();
		sc.close();
	}
}
