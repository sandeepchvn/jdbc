package com.tyss.basics;

import java.sql.DriverManager;

public class Loading {
	public static void main(String[] args) throws ClassNotFoundException
	{
		Class.forName("org.postgresql.Driver");
		System.out.println("Driver loaded");
		DriverManager.getConnection("jdnjn");
	}
}
