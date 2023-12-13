package com.cme.palindrome.impl.service;

import com.cme.palindrome.impl.PalindromeImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PalindromeImplService implements PalindromeImpl {

        private PalindromeCache palindromeCache = new PalindromeCache();

        @Override
        public boolean palindromeChecker(String originalString) {
                StringBuilder reverseValue = new StringBuilder(originalString.toLowerCase()).reverse();
                boolean isPalindrome = false;

                if(!isValidString(originalString)) {
                        log.error("String does not meet the correct format");
                }else{
                        if(palindromeCache.isPalindromeCached(originalString)){
                                log.info("Input is a palindrome and was in the cache: " + originalString);
                                isPalindrome = true;
                        }else{
                                boolean isPalindromeCheck = originalString.contentEquals(reverseValue);
                                log.info(String.valueOf(isPalindromeCheck));
                                // Comparing both values to see if they are equal
                                if(isPalindromeCheck){
                                        palindromeCache.addToCache(originalString);
                                        log.info("Added value " + originalString + " to the cache");
                                        isPalindrome = true;
                                }else {
                                        log.info(String.valueOf(false));
                                }
                        }
                }
                return isPalindrome;
        }

        @Override
        public boolean isValidString(String originalString){
                return originalString.chars().noneMatch(Character::isSpaceChar) && originalString.chars().noneMatch(Character::isDigit);
        }

}