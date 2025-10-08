import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class QNO9 
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/postgres","postgres","root");
		System.out.println("Connection Established");
		Statement st = con.createStatement();
		Scanner sc = new Scanner(System.in);
		int[] empno = new int[3];
        String[] ename = new String[3];
        String[] dob = new String[3]; 
        String[] bg = new String[3];

        for (int i = 0; i < 3; i++) 
        {
            System.out.println("ENTER DETAILS OF EMPLOYEE " + (i + 1));
            System.out.println("Enter Employee Number: ");
            empno[i] = sc.nextInt();
            System.out.println("Enter Employee Name: ");
            ename[i] = sc.next();
            System.out.println("Enter Employee DOB: ");
            dob[i] = sc.next();
            System.out.println("Enter Employee Blood Group: ");
            bg[i] = sc.next();
            String ivalue = "INSERT INTO Emp228 VALUES(" + empno[i] + ", '" + ename[i] + "', '" + dob[i] + "', '" + bg[i] + "')";
            st.executeUpdate(ivalue);
            System.out.println("***VALUES INSERTED***");
            
            System.out.println("***DISPLAYING TABLE***");
           	ResultSet rs = st.executeQuery("SELECT * FROM Emp228");
           	System.out.println(" empno " + "\t" + " ename " + "\t" + " dob " + "\t" + " bg ");
            System.out.println("------------------------------------------------------------");
            while(rs.next())
            {
            	System.out.println(rs.getInt(1) +"\t"+ rs.getString(2) +"\t"+ rs.getString(3) +"\t"+ rs.getString(4));
            }
        }
            con.close();
            sc.close();
	}
}