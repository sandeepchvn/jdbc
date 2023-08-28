package org.tyss.item;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ItemIsert {
	static private String url = "jdbc:postgresql://localhost:5432/item_database?user=postgres&password=root";
	// we have to give database name to above url                  ||||||||||||
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");// load and registered the Driver class // 1st step
			Connection con = DriverManager.getConnection(url);// establish the connection with DB postgresql 2nd
			Statement stm=con.createStatement();// create statement 3rd
			String sql="insert into item values(3,'pen','1 ',20,'rocky')";
			stm.execute(sql); //execute query 4th
			System.out.println("query is executed");
			con.close(); // close connection 5th
		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
