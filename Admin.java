import java.sql.*;
import java.util.*;

public class Admin 
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded...");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		try
		{
			Connection conn=DriverManager.getConnection
					("jdbc:mysql://localhost:3306/test","root","root");
			System.out.println("Connected to database..");
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from admin");
			String name,password;
			while(rs.next())
			{
				System.out.print("Username:");
				name=sc.next();
				System.out.print("Password:");
				password=sc.next();
				if(name.equals(rs.getString(1))&&password.equals(rs.getString(2)))
					System.out.println("Successfully logined as admin..");
				else{
					System.out.println("Wrong credentials");
					break;}
				int ch;
				Admin b=new Admin();
				do
				{
			    System.out.println("1.Add new user\t2.remove user");
				ch=sc.nextInt();
				switch(ch)
				{
				case 1:
					System.out.println("account number");
					int acno=sc.nextInt();
					System.out.println("account name");
					String acname=sc.next();
					System.out.println("account balance");
					double acbalance=sc.nextDouble();
					
					PreparedStatement pstmt=conn.prepareStatement("insert into customer values(?,?,?)");
					pstmt.setInt(1, acno);
					pstmt.setString(2, acname);
					pstmt.setDouble(3, acbalance);
					pstmt.executeUpdate();
				      System.out.println("Element inserted");
						rs=stmt.executeQuery("select * from customer");
						
						while(rs.next())
						{
							System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3));
						}
						break;
				case 2:
					System.out.println("account number");
					acno=sc.nextInt();
					pstmt=conn.prepareStatement("delete from customer where actno=?");
					pstmt.setInt(1, acno);
					pstmt.executeUpdate();
					System.out.println("Removed..");
					rs=stmt.executeQuery("select * from customer");
					
					while(rs.next())
					{
						System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3));
					}
					break;
				}
				}while(ch<=2);
			}
			conn.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
