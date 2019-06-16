import java.sql.*;
import java.sql.SQLException;
import java.util.*;
import java.io.*;
public class Construct {
	public static void main(String args[])
	{
		/* 
		  use BufferedReader instead of Scanner because , here inputs are space separated(full name , address)
		  and scanner only scans tokens(i.e. until it finds a " ") 
		*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PreparedStatement pstmt;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			System.out.println("Success");
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from employee");
			System.out.println("Do you want appliation form if yes enter 1 if no enter 0:");
			int ch = Integer.parseInt(br.readLine());
			String name,eid,adr;
			int exp;
			long pno;
			while(ch>0)
			{
			    System.out.println("\tApplication form");
			    System.out.println("Name:");
			    name = br.readLine();
			    System.out.println("address:");
			    adr = br.readline();
			    System.out.println("phone no:");
			    pno = Long.parseLong(br.readLine());
			    System.out.println("email id:");
			    eid = br.readLine();
			    System.out.println("experience:");
			    exp=Integer.parseInt(br.readLine());
			    pstmt=conn.prepareStatement("insert into employee (name,address,phoneno,email,experience) values(?,?,?,?,?)");
			    pstmt.setString(1, name);
			    pstmt.setString(2, adr);
			    pstmt.setLong(3, pno); // look out for int range, can't handle 10 digit phone number
			    pstmt.setString(4, eid);
			    pstmt.setInt(5, exp); 
			    pstmt.executeUpdate();
			    System.out.println("Do you want appliation form if yes enter 1 if no enter 0:");
			    ch=Integer.parseInt(br.readLine());
			}
			int flag1=1,c;
			System.out.println("Do you want to search by employee id if no enter 0 if yes enter 1");
			c=Integer.parseInt(br.readLine());
			if(c>0)
			{
			    System.out.println("Enter empid:");
			    int n=Integer.parseInt(br.readLine());
			    System.out.println("empid name address phoneno email experience");
			    rs=stmt.executeQuery("select * from employee");
			    int flag=1;
			    if(flag==1)
			    {
				while(rs.next())
				{
				    if(rs.getInt(1)==n) 
				    {
					      System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getLong(4)+" "+rs.getString(5)+" "+rs.getInt(6));
					      flag=0;
				    }
				}
			    }
			    else
			    {
				    while(rs.next())
					    System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5)+" "+rs.getInt(6));
			    }
			    flag1=0;
			}
			else
			{
				while(rs.next())
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5)+" "+rs.getInt(6));
			}
			// always close the jdbc interfaces
			close(conn, stmt, rs);
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	private static void close(Connection conn, Statement stmt, ResultSet rs) throws SQLException {

		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	}
}
