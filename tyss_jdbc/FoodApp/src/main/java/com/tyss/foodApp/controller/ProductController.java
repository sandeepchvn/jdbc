package com.tyss.foodApp.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.tyss.foodApp.bean.Product;

public class ProductController {
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

	public void saveProduct(Product product) {
		Connection connection = getConnection();
		try {
			PreparedStatement pstm = connection.prepareStatement("insert into product values(?,?,?,?,?)");
			pstm.setInt(1, product.getProductId());
			pstm.setString(2, product.getProductName());
			pstm.setString(3, product.getProductDescription());
			pstm.setDouble(4, product.getProductPrice());
			pstm.setInt(5, product.getOrderId());
			pstm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Product findProduct(int orderid) {
		Connection connection = getConnection();
		Product product = new Product();
		try {
			PreparedStatement pstm = connection.prepareStatement("select * from product where orderid=?");
			pstm.setInt(1, orderid);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
			product.setProductId(rs.getInt(1));
			product.setProductName(rs.getString(2));
			product.setProductDescription(rs.getString(3));
			product.setProductPrice(rs.getDouble(4));
			product.setOrderId(rs.getInt(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return product;
	}

	public boolean updateProduct(int id, double price) {
		if (findProduct(id) != null) {
			Connection connection = getConnection();
			Product product = new Product();
			try {
				PreparedStatement pstm = connection
						.prepareStatement("update product set productprice=? where productid=?");
				pstm.setDouble(1, price);
				pstm.setInt(2, id);
				pstm.execute();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean deleteProduct(int id) {
		if (findProduct(id) != null) {
			Connection connection = getConnection();
			Product product = new Product();
			try {
				PreparedStatement pstm = connection
						.prepareStatement("delete from product where productid=?");
				pstm.setInt(1, id);
				pstm.execute();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
}
