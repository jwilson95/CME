package main;

import com.cme.palindrome.impl.PalindromeImpl;
import com.cme.palindrome.impl.service.PalindromeImplService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

@ExtendWith(MockitoExtension.class)
class CmeApplicationTests {

	private PalindromeImpl palindrome;

	@BeforeEach
	void setup(){
		palindrome = Mockito.spy(new PalindromeImplService());
	}

	@Test
	void testIsPalindrome() throws IOException {
		Assertions.assertTrue(palindrome.palindromeChecker("madam"));
	}

	@Test
	void testIsNotPalindrome() throws IOException {
		Assertions.assertFalse(palindrome.palindromeChecker("test"));
	}

	@Test
	void isPalindromeCached() throws IOException {
		palindrome.palindromeChecker("madam");
		Mockito.verify(palindrome, Mockito.times(1)).palindromeChecker("madam");
	}

	@Test
	void testIsValidStringTrue(){
		Assertions.assertTrue(palindrome.isValidString("madam"));
	}

	@Test
	void testIsValidStringFalseSpace(){
		Assertions.assertFalse(palindrome.isValidString("madam "));
	}

	@Test
	void testIsValidStringFalseNumber(){
		Assertions.assertFalse(palindrome.isValidString("1madam"));
	}

}
