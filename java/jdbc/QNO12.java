import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class QNO12 
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/postgres","postgres","root");
		System.out.println("Connection Established");
		Scanner sc = new Scanner(System.in);
		Statement st = con.createStatement();
		
		int[] pid = new int[3];
		String[] pname = new String[3];
		String[] desc = new String[3];
		int[] price = new int[3];
		int[] qis = new int[3];
		int[] cid = new int[3];
		String[] created_at = new String[3];
		
		for(int i=0;i<3;i++)
		{
			System.out.println("ENTER DETAILS OF PRODUCT "+(i+1));
			System.out.println("Enter Product ID : ");
			pid[i] = sc.nextInt();
			System.out.println("Enter Product Name : ");
			pname[i] = sc.next();
			System.out.println("Enter Product Description : ");
			desc[i] = sc.next();
			System.out.println("Enter Product Price : ");
			price[i] = sc.nextInt();
			System.out.println("Enter Product Quantity in Stock : ");
			qis[i] = sc.nextInt();
			System.out.println("Enter Product Category ID : ");
			cid[i] = sc.nextInt();
			System.out.println("Enter Product Created At : ");
			created_at[i] = sc.next();
			String ivalue = "INSERT INTO Products228 VALUES("+pid[i]+",'"+pname[i]+"','"+desc[i]+"',"+price[i]+","+qis[i]+","+cid[i]+",'"+created_at[i]+"')";
			st.executeUpdate(ivalue);
			System.out.println("***VALUES INSERTED***");
		}
		
		int[] timestamp = new int[3];
		System.out.println("NEW COLUMN");
		String newcol = "ALTER TABLE Products228 ADD timestamp int"; 
		st.executeUpdate(newcol);
		System.out.println("Enter Product ID : ");
		pid[3] = sc.nextInt();
		System.out.println("Enter Product Name : ");
		pname[3] = sc.next();
		System.out.println("Enter Product Description : ");
		desc[3] = sc.next();
		System.out.println("Enter Product Price : ");
		price[3] = sc.nextInt();
		System.out.println("Enter Product Quantity in Stock : ");
		qis[3] = sc.nextInt();
		System.out.println("Enter Product Category ID : ");
		cid[3] = sc.nextInt();
		System.out.println("Enter Product Created At : ");
		created_at[3] = sc.next();
		System.out.println("Enter Product Timestamp : ");
		timestamp[3] = sc.nextInt();
		String ivalue = "INSERT INTO Products228 VALUES("+pid[3]+",'"+pname[3]+"','"+desc[3]+"',"+price[3]+","+qis[3]+","+cid[3]+",'"+created_at[3]+"',"+timestamp[3]+")";
		st.executeUpdate(ivalue);
		System.out.println("***VALUES INSERTED***");
		
		System.out.println("Enter Product Name to Update : ");
		String oldname = sc.next();
		System.out.println("Enter New Quantity : ");
		int newvalue = sc.nextInt();
		String uvalue = "UPDATE Products228 SET qis="+newvalue+" WHERE pname ='"+oldname+"'";
		st.executeUpdate(uvalue);
		System.out.println("***VALUE UPDATE***");
		
		System.out.println("DELETE QUERY");
		String dvalue = "DELETE FROM Products228 WHERE qis = 0";
		st.executeUpdate(dvalue);
		System.out.println("***VALUE DELETED***");
		
		con.close();
		sc.close();
	}
}

