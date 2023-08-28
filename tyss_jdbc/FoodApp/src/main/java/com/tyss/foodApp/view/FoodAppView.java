package com.tyss.foodApp.view;

import java.sql.Savepoint;
import java.util.Scanner;

import com.tyss.foodApp.bean.Order;
import com.tyss.foodApp.bean.Product;
import com.tyss.foodApp.controller.OrderController;
import com.tyss.foodApp.controller.ProductController;

public class FoodAppView {
	static OrderController orderController = new OrderController();
	static ProductController productController = new ProductController();
	static Scanner read = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			System.out.println("enter 1 for Product\nenter 2 for Order");
			int choice = read.nextInt();
			if (choice == 1) {
				System.out.println(
						"enter 1 to save product \nenter 2 to find product by order id\nenter 3 to update price of product\nenter 4 to delete product");
				switch (read.nextInt()) {
				case 1: {
					saveProduct();
					break;
				}
				case 2: {
					findProduct();
					break;
				}
				case 3: {
					updateProductPriceByID();
					break;
				}
				case 4: {
					deleteProductById();
					break;
				}
				}
			} else if (choice == 2) {
				System.out.println(
						"enter 1 to save order \nenter 2 to find order \nenter 3 to update order number\nenter 4 to delete order");
				switch (read.nextInt()) {
				case 1: {
					saveOrder();
					break;
				}
				case 2: {
					findOrder();
					break;
				}
				case 3: {
					updateOrder();
					break;
				}
				case 4: {
					deleteOrder();
					break;
				}

				}
			}
		}
	}

	public static void saveProduct() {
		System.out.println("enter id,name,description,price,order id");
		Product product = new Product();
		product.setProductId(read.nextInt());
		product.setProductName(read.next());
		product.setProductDescription(read.next());
		product.setProductPrice(read.nextDouble());
		product.setOrderId(read.nextInt());
		productController.saveProduct(product);
	}
	public static void saveOrder() {
		System.out.println("enter order id,order number");
		Order order = new Order();
		order.setOrderId(read.nextInt());
		order.setOrderNumber(read.next());
		orderController.saveOrder(order);
	}
	public static void findOrder() {
		System.out.println("engter order id");
		int order_id = read.nextInt();
		Product product = productController.findProduct(order_id);
		System.out.println(product.getProductId());
		System.out.println(product.getProductName());
		System.out.println(product.getProductDescription());
		System.out.println(product.getProductPrice());
		System.out.println(product.getOrderId());
		Order order = orderController.findOrder(order_id);
		System.out.println(order.getOrderId());
		System.out.println(order.getOrderNumber());
	}
	public static void findProduct() {
		System.out.println("enter order id");
		Product product = productController.findProduct(read.nextInt());
		System.out.println(product.getProductId());
		System.out.println(product.getProductName());
		System.out.println(product.getProductDescription());
		System.out.println(product.getProductPrice());
		System.out.println(product.getOrderId());
	}
	public static void updateProductPriceByID() {
		System.out.println("enter product id and price");
		productController.updateProduct(read.nextInt(), read.nextDouble());
		System.out.println("product updeted-----!");
	}
	public static void deleteProductById() {
		System.out.println("engter product id");
		productController.deleteProduct(read.nextInt());
		System.out.println("product deleted----!");
	}
	public static void updateOrder() {
		System.out.println("enter order id,order number");
		orderController.updateOrder(read.nextInt(), read.next());
		System.out.println("order updeted----!");
	}
	public static void deleteOrder() {
		System.out.println("enter order id");
		orderController.deleteOrder(read.nextInt());
		System.out.println("order deleted----!");
	}
}
