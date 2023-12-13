package com.cme.palindrome.impl.service;

import com.cme.palindrome.impl.PalindromeImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;

@Slf4j
@Service
public class PalindromeImplService implements PalindromeImpl {

        private final PalindromeCache palindromeCache = new PalindromeCache();

        @Override
        public boolean palindromeChecker(String originalString) throws IOException {
                if (!isValidString(originalString)) {
                        log.error("String does not meet the correct format");
                        return false;
                }

                String lowerCaseString = originalString.toLowerCase();
                String reverseValue = new StringBuilder(lowerCaseString).reverse().toString();
                boolean isPalindromeCheck = lowerCaseString.equals(reverseValue);

                if(!originalString.isEmpty()){
                        if (palindromeCache.isPalindromeCached(originalString)) {
                                log.info("Input is a palindrome and was in the cache: " + originalString);
                        } else {
                                if (isPalindromeCheck) {
                                        palindromeCache.addToCache(originalString);
                                        log.info("Added string " + originalString + " to the cache");
                                        saveToPermanentCache(originalString);
                                } else {
                                        log.error("Not a Palindrome: " + originalString);
                                }
                        }
                }
                return isPalindromeCheck;
        }

        @Override
        public boolean isValidString(String originalString){
                return originalString.chars().noneMatch(Character::isSpaceChar) && originalString.chars().noneMatch(Character::isDigit);
        }

        @Override
        public void loadPermanentCache() {
                final String filepath = "cacheFile.csv";
                try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                                palindromeCache.addToCache(line);
                        }
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

        @Override
        public void saveToPermanentCache(String input) throws IOException {
                if (palindromeCache.isPalindromeCached(input)){
                        final String filepath = "cacheFile.csv";
                        try(BufferedWriter br = new BufferedWriter(new FileWriter(filepath, true))){
                                br.write(input + ",");
                                log.info(input + " has been saved to permanent cache");
                        }
                }
        }

}