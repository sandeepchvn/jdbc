package com.tyss.foodApp.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tyss.foodApp.bean.Order;
import com.tyss.foodApp.bean.Product;

public class OrderController {
	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/foodApp_jdbc?user=postgres&password=root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	public void saveOrder(Order order) {
		Connection connection = getConnection();
		try {
			PreparedStatement pstm = connection.prepareStatement("insert into \"order\" values(?,?)");
			pstm.setInt(1, order.getOrderId());
			pstm.setString(2, order.getOrderNumber());
			pstm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Order findOrder(int orderid) {
		Connection connection = getConnection();
		Order order=new Order();
		try {
			PreparedStatement pstm = connection.prepareStatement("select * from \"order\" where orderid=?");
			pstm.setInt(1, orderid);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
			order.setOrderId(rs.getInt(1));
			order.setOrderNumber(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return order;
	}

	public boolean updateOrder(int orderid, String orderNum) {
		if (findOrder(orderid) != null) {
			Connection connection = getConnection();
			Order order=new Order();
			try {
				PreparedStatement pstm = connection
						.prepareStatement("update \"order\" set ordernumber=? where orderid=?");
				pstm.setString(1, orderNum);
				pstm.setInt(2, orderid);
				pstm.execute();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean deleteOrder(int orderid) {
		if (findOrder(orderid) != null) {
			Connection connection = getConnection();
			Order order=new Order();
			try {
				PreparedStatement pstm = connection
						.prepareStatement("delete from \"order\" where orderid=?");
				pstm.setInt(1, orderid);
				pstm.execute();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
}
