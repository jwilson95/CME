package com.cme.palindrome.controller;

import com.cme.palindrome.impl.PalindromeImpl;
import com.cme.palindrome.model.Input;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cme_challenge")
public class PalindromeController {

    private final PalindromeImpl palindromeImpl;

    @Autowired
    public PalindromeController(PalindromeImpl palindromeImpl) {
        this.palindromeImpl = palindromeImpl;
    }

    @PostMapping("/isPalindrome")
    public boolean isPalindrome(@RequestBody Input originalString) {
        return palindromeImpl.palindromeChecker(originalString.getOriginalString());
    }
}
