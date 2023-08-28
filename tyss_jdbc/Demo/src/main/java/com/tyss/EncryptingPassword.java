package com.tyss;

import java.util.Scanner;

import org.mindrot.jbcrypt.BCrypt;

public class EncryptingPassword {
	public static void main(String[] args) {
		String password = "123";

		// Generate a salt value
		String salt = BCrypt.gensalt();

		// Generate the hashed password
		String hashedPassword = BCrypt.hashpw(password, salt);

		// Print the hashed password
		System.out.println("Hashed Password: " + hashedPassword);
		System.out.println("enter password");
		Scanner ac=new Scanner(System.in);
		String pas=ac.next();
		if(BCrypt.checkpw(pas, hashedPassword)) {
			System.out.println("true");
		}else
			System.out.println("false");
//		String enteredPassword = "myPassword123";
//		boolean isPasswordCorrect = BCrypt.checkpw(enteredPassword, hashedPassword);
	}
}
