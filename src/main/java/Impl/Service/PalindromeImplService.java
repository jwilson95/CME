package impl.service;

import impl.PalindromeImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class PalindromeImplService implements PalindromeImpl {

        private PalindromeCache palindromeCache = new PalindromeCache();

        @Override
        public boolean palindromeChecker(String input) {
                StringBuilder reverseValue = new StringBuilder();

                if(isValidString(input)){
                        if(palindromeCache.isPalindromeCached(input)){
                                log.info("Input is a palindrome and was in the cache: " + input);
                        }else{
                                // Go to the end of the string and get each char
                                for (int i = input.length() - 1; i >=0; i--){
                                        // Appends each char to the end of the string value reverseValue until loop finishes
                                        reverseValue.append(input.charAt(i));
                                }
                        }
                        // Comparing both values to see if they are equal
                        if(Objects.equals(input, reverseValue.toString())){
                                log.info(String.valueOf(true));
                                palindromeCache.addToCache(input);
                                log.info("Added value " + input + " to cache");
                        }else {
                                log.info(String.valueOf(false));
                        }
                }
                return false;
        }

        public boolean isValidString(String input){
                return !input.chars().anyMatch(Character::isSpaceChar) && !input.chars().anyMatch(Character::isDigit);
        }

}
