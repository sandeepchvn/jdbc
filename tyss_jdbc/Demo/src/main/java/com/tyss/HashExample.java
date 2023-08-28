package com.tyss;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashExample {

	public static void main(String[] args) {
		String message = "Hello, World!";

		String sha1Result = sha1Hash(message);
		System.out.println("SHA1: " + sha1Result);

		String sha256Result = sha256Hash(message);
		System.out.println("SHA256: " + sha256Result);
	}

	public static String sha1Hash(String data) {
		try {
			MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
			byte[] hashBytes = sha1.digest(data.getBytes());

			return bytesToHex(hashBytes);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String sha256Hash(String data) {
		try {
			MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
			byte[] hashBytes = sha256.digest(data.getBytes());

			return bytesToHex(hashBytes);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static String bytesToHex(byte[] bytes) {
		StringBuilder hexString = new StringBuilder();
		for (byte b : bytes) {
			String hex = Integer.toHexString(0xff & b);
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);
		}
		return hexString.toString();
	}
}
