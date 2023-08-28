package com.tyss.basics;

public class LoadingDemo {
	public static void main(String[] args) throws ClassNotFoundException {
		//Bike b=new Bike();
		Class.forName("com.tyss.basics.Bike");// 1st way
	}
}
class Bike{
	static {
       		System.out.println("static Block of bike");
	}
}

