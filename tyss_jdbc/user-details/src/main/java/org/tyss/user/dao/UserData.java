package org.tyss.user.dao;

import java.util.Scanner;

public class UserData {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String y;
		do {

			int id;
			String name;
			long phone;
			String password;
			UserDao dao = new UserDao();
			System.out.println("enter 1 to insert");
			System.out.println("enter 2 to update");
			System.out.println("enter 3 to delete");
			System.out.println("enter 4 to fetch");
			int key = sc.nextInt();

			switch (key) {
			case 1:
				System.out.println("enter id, name ,phone, password");
				id = sc.nextInt();
				name = sc.next();
				phone = sc.nextLong();
				password = sc.next();
				dao.saveUser(id, name, phone, password);
				break;
			case 2:
				System.out.println("enter id to update");
				id = sc.nextInt();
				System.out.println("enter new password");
				password = sc.next();
				dao.updateUser(id, password);
				break;
			case 3:
				System.out.println("enter id to delete");
				id = sc.nextInt();
				dao.deleteUser(id);
				break;
			case 4:
				System.out.println("enter id to Fetch the record");
				id = sc.nextInt();
				dao.fetchUser(id);
				break;
			}
			System.out.println("if u want to continue type y");
			y = sc.next();
		} while (y.equals("y") || y.equals("Y"));
	}
}
