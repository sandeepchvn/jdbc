package com.tyss.bookticket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TrainTicket {
	static private String url = "jdbc:postgresql://localhost:5432/ticket";
	static private String userName = "postgres";
	static private String password = "root";

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(url, userName, password);
			String sqlBook_info = "insert into booking_info values(1,'AIR-IND-101','BLR','US')";
			String sqlPass_info1 = "insert into passenger_info values(1,'sandeep',24,'male')";
			String sqlPass_info2 = "insert into passenger_info values(2,'sumeet',20,'male')";
			String sqlPay_info = "insert into payment_info values(1,1,25000,700,'requested')";
			connection.setAutoCommit(false);
			Statement statement1 = connection.createStatement();
			statement1.execute(sqlBook_info);
			Statement statement2 = connection.createStatement();
			statement2.execute(sqlPass_info1);
			Statement statement3 = connection.createStatement();
			statement3.execute(sqlPass_info2);
			if (DemoPaymentGateway.isSuccess()) {
				Statement statement4 = connection.createStatement();
				statement4.execute(sqlPay_info);
				connection.commit();
				System.out.println("Transaction completed");
			} else {
				connection.rollback();
				System.out.println("Transaction failed, data reverted");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
