package com.cme.palindrome;

import com.cme.palindrome.impl.service.PalindromeCache;
import com.cme.palindrome.impl.service.PalindromeServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CMEApplication {

	public static void main(String[] args) {
		SpringApplication.run(CMEApplication.class, args);
	}

}