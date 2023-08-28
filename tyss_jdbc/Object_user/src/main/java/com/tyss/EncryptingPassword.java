package com.tyss;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncryptingPassword {

	public static void main(String[] args) throws Exception {
		String password = "myPassword";
		String secretKey = "mySecretKey";

		// Encrypting the password
		String encryptedPassword = encrypt(password, secretKey);
		System.out.println("Encrypted Password: " + encryptedPassword);

		// Decrypting the password
		String decryptedPassword = decrypt(encryptedPassword, secretKey);
		System.out.println("Decrypted Password: " + decryptedPassword);
	}

	public static String encrypt(String data, String secretKey) throws Exception {
		SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "AES");
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, keySpec);
		byte[] encryptedBytes = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
		return Base64.getEncoder().encodeToString(encryptedBytes);
	}

	public static String decrypt(String encryptedData, String secretKey) throws Exception {
		SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "AES");
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, keySpec);
		byte[] encryptedBytes = Base64.getDecoder().decode(encryptedData);
		byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
		return new String(decryptedBytes, StandardCharsets.UTF_8);
	}
}
