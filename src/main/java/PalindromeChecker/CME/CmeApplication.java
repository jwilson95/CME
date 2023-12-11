package PalindromeChecker.CME;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class CmeApplication {

//	public static void main(String[] args) {
//		SpringApplication.run(CmeApplication.class, args);
//	}

	PalindromeImplService palindromeImplService;

	private CmeApplication(PalindromeImplService palindromeImplService){
		this.palindromeImplService = palindromeImplService;
	}
	public static void main(String[] args)
	{
		PalindromeImplService.palindromeChecker("131");
	}

}
