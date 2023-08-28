package org.tyss.item;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ItemDelete {
	
public static void main(String[] args) {
	try {
		Class.forName("org.postgresql.Driver");//1st
		String url="jdbc:postgresql://localhost:5432/item_database?user=postgres&password=root";
		Connection con=DriverManager.getConnection(url);//2nd
		Statement stm=con.createStatement();//3rd
		Scanner sc= new Scanner(System.in);
		System.out.println("enter the id to delete the item");
		int id=sc.nextInt();
		String sql="delete from item where id="+id;
		stm.execute(sql);//4rth
		con.close();//5th
		System.out.println("item is deleted");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
