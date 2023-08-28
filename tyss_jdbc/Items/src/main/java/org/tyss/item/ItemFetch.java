package org.tyss.item;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ItemFetch {
public static void main(String[] args) {
	try {
		Class.forName("org.postgresql.Driver");
		Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/item_database?user=postgres&password=root");;
		Statement stm=con.createStatement();
		String sql="select * from item";
		ResultSet rs=stm.executeQuery(sql);
		while(rs.next()) {
			System.out.println("id "+rs.getInt(1));
			System.out.println("name "+rs.getString(2));
			System.out.println("quantity "+rs.getString(3));
			System.out.println("price "+rs.getDouble(4));
			System.out.println("manufacturer "+rs.getString(5));
			System.out.println("----------------------------------");
		}
		//System.out.println(rs.next());
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}
