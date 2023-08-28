package com.tyss.connectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
	private static List<Connection> connectionPool = new ArrayList();
	private static String driverPath = "org.postgresql.Driver";
	private static String URL = "jdbc:postgresql://localhost:5432/demo";
	private static String userName = "postgres";
	private static String password = "root";
	private static final int POOL_SIZE = 5;
	static {
		try {
			Class.forName(driverPath);
			for (int i = 0; i < POOL_SIZE; i++) {
				Connection connection = DriverManager.getConnection(URL, userName, password);
				connectionPool.add(connection);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnectionObject() {
		if(! connectionPool.isEmpty()) {
			return connectionPool.remove(0);
		}
		return createConnection();
	}

	public static Connection createConnection() {
		Connection connection=null;
		try {
			connection=DriverManager.getConnection(URL,userName,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	public static void receiveConnectionObject(Connection connection) {
		if(connectionPool.size()<POOL_SIZE) 
		{
			connectionPool.add(connection);
		}
		else {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
