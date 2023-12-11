package main;

import Impl.Service.PalindromeImplService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class CMEApplication {

//	public static void main(String[] args) {
//		SpringApplication.run(CmeApplication.class, args);
//	}

	public static void main(String[] args) {
		PalindromeImplService palindromeImplService = new PalindromeImplService();
		palindromeImplService.palindromeChecker("test","madam");
	}

}
