import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class QNO11 
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/postgres","postgres","root");
		System.out.println("Connection Established");
		Scanner sc = new Scanner(System.in);
		Statement st = con.createStatement();
		
		int[] sid = new int[3];
        String[] fname = new String[3];
        String[] lname = new String[3];
        String[] semail = new String[3];
        String[] enr_date = new String[3];
        float[] gpa = new float[3];
        int[] mid = new int[3];

        for (int i = 0; i < 3; i++) 
        {
            System.out.println("ENTER DETAILS OF STUDENT " + (i + 1));
            System.out.println("Enter Student Roll Number: ");
            sid[i] = sc.nextInt();
            System.out.println("Enter Student First Name: ");
            fname[i] = sc.next();
            System.out.println("Enter Student Last Name: ");
            lname[i] = sc.next();
            System.out.println("Enter Student Email: ");
            semail[i] = sc.next();
            System.out.println("Enter Student Enrollment Date: ");
            enr_date[i] = sc.next();
            System.out.println("Enter Student GPA: ");
            gpa[i] = sc.nextFloat();
            System.out.println("Enter Student Major ID: ");
            mid[i] = sc.nextInt();
            String ivalue = "INSERT INTO Students228 VALUES(" +sid[i] + ", '" + fname[i] + "', '" + lname[i] + "' , '" + semail[i] + "' , '" + enr_date[i] + "', " + gpa[i] + "," + mid[i] + ")";
            st.executeUpdate(ivalue);
            System.out.println("***VALUES INSERTED***");
            
            System.out.println("***DISPLAYING TABLE***");
           	ResultSet rs = st.executeQuery("SELECT * FROM Students228");
           	System.out.println(" sid " + "\t" + " first_name " + "\t" + " last_name " + "\t" + " email " + "\t" + " enr_date " + "\t" + " gpa " + "\t" + " major_id ");
            System.out.println("-----------------------------------------------------------------------------------------------");
            while(rs.next())
            {
            	System.out.println(rs.getInt(1) +"\t"+ rs.getString(2) +"\t"+ rs.getString(3) +"\t"+ rs.getString(4) +"\t"+ rs.getString(5) +"\t"+ rs.getFloat(6) +"\t"+ rs.getInt(7));
            }
        }
        
        System.out.println("UPDATE QUERY");
		System.out.println("Enter Student's Name : ");
		String oldvalue = sc.next();
		System.out.println("Enter GPA : ");
		float newvalue = sc.nextFloat();
		String uvalue = "UPDATE Students228 SET gpa ="+newvalue+" WHERE fname ="+oldvalue;
		st.executeUpdate(uvalue);
		System.out.println("***VALUE UPDATE***");

		System.out.println("DELETE QUERY");
		System.out.println("Enter Student email to Delete : ");
		String dname = sc.next();
		String dvalue = "DELETE FROM Students228 WHERE email ='"+dname+"'";
		st.executeUpdate(dvalue);
		System.out.println("***VALUE DELETED***");
		
        con.close();
		sc.close();
	}
}
