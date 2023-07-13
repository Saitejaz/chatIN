package com.chatapp.main.Auth.Registration;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {

	private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public static String hashedPassword(String password) {
		return passwordEncoder.encode(password);
	}
	
	public static boolean verifyPassword(String password,String hashedPassword) {
		return passwordEncoder.matches(password, hashedPassword);
	}
	
}
