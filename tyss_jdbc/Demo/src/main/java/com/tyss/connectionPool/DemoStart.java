package com.tyss.connectionPool;

import java.sql.Connection;
import java.sql.SQLException;

public class DemoStart {

	public static void main(String[] args) {
		try {
			Connection con=Demo_pool.giveConnectionObject();
			System.out.println(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
}
