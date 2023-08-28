package teacher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Teacher {
public static void main(String[] args) {
	String url="jdbc:postgresql://localhost:5432/teacher";
	String user="postgres";
	String password="root";
	try {
		Class.forName("org.postgresql.Driver");
		Connection con=DriverManager.getConnection(url, user, password);
		Statement stm=con.createStatement();
		Scanner sc= new Scanner(System.in);
		System.out.println("enter id,name,email,phone,subject,salary,desg,school");
		int id=sc.nextInt();
		String name=sc.next();
		String email=sc.next();
		long phone=sc.nextLong();
		String subject=sc.next();
		double salary=sc.nextDouble();
		String desg=sc.next();
		String school=sc.next();
		String sql="insert into teacher_table values("+id+",'"+name+"','"+email+"',"+phone+",'"+subject+"',"+salary+",'"+desg+"','"+school+"')";
		//String sql="INSERT INTO emp VALUES(1,'sandeep','sandy@gmail.com','Trainer',888,'Trainer department', 30000.0,'123')";
		//String sql="update teacher_table set name='sumit' where id=1";
		//String sql="delete from teacher_table where id=1";
		stm.execute(sql);
		System.out.println("query is done");
		System.out.println("enter y to continue");
		String n=sc.next();
		
		con.close();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}
