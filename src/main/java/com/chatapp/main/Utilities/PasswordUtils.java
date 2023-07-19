package com.chatapp.main.Utilities;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class PasswordUtils {

	private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public static String hashedPassword(String password) {
		return passwordEncoder.encode(password);
	}
	
	public static boolean verifyPassword(String rawPassword,String hashedPassword) {
		return passwordEncoder.matches(rawPassword,hashedPassword);
	}
	
}
