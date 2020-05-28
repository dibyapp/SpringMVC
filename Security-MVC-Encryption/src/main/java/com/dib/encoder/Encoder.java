package com.dib.encoder;

import java.util.Scanner;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encoder {
	
	public static void main(String[] args) {
		BCryptPasswordEncoder pec = new BCryptPasswordEncoder();
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Password To Encrypt");
		String pass = sc.next();
		
		String encoded = pec.encode(pass);
		
		System.out.println(encoded);
	}

}
