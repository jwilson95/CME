package controller;

import impl.PalindromeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/cme_challenge")
public class PalindromeController {

    private final PalindromeImpl palindrome;

    @Autowired
    public PalindromeController(PalindromeImpl palindrome) {
        this.palindrome = palindrome;
    }

    @PostMapping("/isPalindromeTest")
    public boolean isPalindrome(@RequestBody String input) {
        return palindrome.palindromeChecker(input);
    }
}
