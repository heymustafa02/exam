import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class QNO10 
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
		String ctable= "CREATE TABLE "+tname+"("+fcol+" int, "+scol+" varchar(20), "+tcol+" varchar(20), " +ftcol+" float , "+fvcol+" int)";
		st.executeUpdate(ctable);
		System.out.println("***TABLE CREATED***");
		
		int[] eid = new int[3];
        String[] ename = new String[3];
        String[] eemail = new String[3];
        float[] esal = new float[3];
        int[] deptid = new int[3];

        for (int i = 0; i < 3; i++) 
        {
            System.out.println("ENTER DETAILS OF EMPLOYEE " + (i + 1));
            System.out.println("Enter Emloyee Number: ");
            eid[i] = sc.nextInt();
            System.out.println("Enter Employee Name: ");
            ename[i] = sc.next();
            System.out.println("Enter Employee Email: ");
            eemail[i] = sc.next();
            System.out.println("Enter Employee Salary: ");
            esal[i] = sc.nextFloat();
            System.out.println("Enter Department ID: ");
            deptid[i] = sc.nextInt();
            String ivalue = "INSERT INTO " + tname + " VALUES(" +eid[i] + ", '" + ename[i] + "', '" + eemail[i] + "', " + esal[i] + ", " + deptid[i] + ")";
            st.executeUpdate(ivalue);
            System.out.println("***VALUES INSERTED***");
        }
		
		System.out.println("UPDATE QUERY");
		System.out.println("Enter Employee Name : ");
		String oldvalue = sc.next();
		System.out.println("Enter New Salary Value : ");
		float newvalue = sc.nextFloat();
		String uvalue = "UPDATE "+tname+" SET "+ftcol+"="+newvalue+" WHERE "+scol+"='"+oldvalue+"'";
		st.executeUpdate(uvalue);
		System.out.println("***VALUE UPDATE***");
		
		System.out.println("DELETE QUERY");
		System.out.println("Enter Employee ID to Delete : ");
		int did = sc.nextInt();
		String dvalue = "DELETE FROM "+tname+" WHERE "+fcol+"="+did;
		st.executeUpdate(dvalue);
		System.out.println("***VALUE DELETED***");
		
		ResultSet rs = st.executeQuery("SELECT * FROM "+tname+" WHERE "+ftcol+">50000");
		System.out.println(" eid " + "\t" + " ename " + "\t" + " email " + "\t" + " salary " + "\t" + " department_id ");
		System.out.println("------------------------------------------------------------------------------------------");
		while(rs.next())
		{
			System.out.println(rs.getInt(1) +"\t"+ rs.getString(2) +"\t"+ rs.getString(3) +"\t"+ rs.getFloat(4) +"\t"+ rs.getInt(5));
		}
		
		con.close();
		sc.close();
	}
}
