package Impl.Service;

import Impl.PalindromeImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Slf4j
@Service
public class PalindromeImplService implements PalindromeImpl {

        private PalindromeCache palindromeCache;

        public PalindromeImplService(){
        }
        public PalindromeImplService(PalindromeCache palindromeCache){
                this.palindromeCache = palindromeCache;
        }

        @Override
        public void palindromeChecker(@RequestParam String userName, @RequestParam String input) {
                StringBuilder reverseValue = new StringBuilder();

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
                }else {
                        log.info(String.valueOf(false));
                }
        }

}
