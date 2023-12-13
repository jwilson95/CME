package com.cme.palindrome.impl.service;

import com.cme.palindrome.impl.PalindromeImpl;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Slf4j
@Service
public class PalindromeImplService implements PalindromeImpl {

        private final PalindromeCache palindromeCache = new PalindromeCache();

        @Override
        public boolean palindromeChecker(String originalString) {
                loadPermanentCache();

                if (!isValidString(originalString)) {
                        log.error("String does not meet the correct format");
                        return false;
                }

                String lowerCaseString = originalString.toLowerCase();
                String reverseValue = new StringBuilder(lowerCaseString).reverse().toString();
                boolean isPalindromeCheck = lowerCaseString.equals(reverseValue);

                if (palindromeCache.isPalindromeCached(originalString)) {
                        log.info("Input is a palindrome and was in the cache: " + originalString);
                } else {
                        if (isPalindromeCheck && !palindromeCache.isPalindromeCached(originalString)) {
                                palindromeCache.addToCache(originalString);
                                log.info("Added string " + originalString + " to the cache");
                        } else {
                                log.error("Not a Palindrome: " + originalString);
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
}