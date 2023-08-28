package org.tyss.item;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ItemUpdate {
	static private String url="jdbc:postgresql://localhost:5432/item_database?user=postgres&password=root";
public static void main(String[] args) {
	try {
		Class.forName("org.postgresql.Driver");
		Connection con=DriverManager.getConnection(url);
		Statement stm=con.createStatement();
		String sql="update item set name='phone' , quantity='3',price=30, manufacturer='satish' where id=3" ;
		stm.execute(sql);
		System.out.println("query updated successfully");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}
