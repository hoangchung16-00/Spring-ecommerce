package com.example.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
		System.out.println("Đã Load Xong!");

//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		String passwordRaw = "admin";
//		String encodePassword =  encoder.encode(passwordRaw);
//		System.out.println(encodePassword);
	}

}
