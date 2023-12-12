package main;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class CMEApplication {

	public static void main(String[] args) {
		SpringApplication.run(CMEApplication.class, args);
	}

//	public static void main(String[] args) {
//		PalindromeImplService palindromeImplService = new PalindromeImplService();
//		palindromeImplService.palindromeChecker("madam");
//	}

}
