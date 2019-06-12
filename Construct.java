import java.sql.*;
import java.sql.SQLException;
import java.util.*;
public class Construct {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		PreparedStatement pstmt;
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		System.out.println("Success");
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from employee");
		System.out.println("Do you want appliation form if yes enter 1 if no enter 0:");
		int ch=sc.nextInt();
		String name,eid,adr;
		int pno,exp;
		while(ch>0)
		{
		    System.out.println("\tApplication form");
		    System.out.println("Name:");
		    name=sc.next();
		    System.out.println("address:");
		    adr=sc.next();
		    System.out.println("phone no:");
		    pno=sc.nextInt();
		    System.out.println("email id:");
		    eid=sc.next();
		    System.out.println("experience:");
		    exp=sc.nextInt();
		    pstmt=conn.prepareStatement("insert into employee (name,address,phoneno,email,experience) values(?,?,?,?,?)");
		    pstmt.setString(1, name);
		    pstmt.setString(2, adr);
		    pstmt.setInt(3, pno);
		    pstmt.setString(4, eid);
		    pstmt.setInt(5, exp);
		    pstmt.executeUpdate();
	 	    System.out.println("Do you want appliation form if yes enter 1 if no enter 0:");
		    ch=sc.nextInt();
		}
		int flag1=1,c;
		System.out.println("Do you want to search by employee id if no enter 0 if yes enter 1");
		c=sc.nextInt();
		if(c>0)
		{
		    System.out.println("Enter empid:");
		    int n=sc.nextInt();
		    System.out.println("empid name address phoneno email experience");
		    rs=stmt.executeQuery("select * from employee");
		    int flag=1;
		    if(flag==1)
		    {
		        while(rs.next())
		        {
		            if(rs.getInt(1)==n) 
		            {
			              System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5)+" "+rs.getInt(6));
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
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
