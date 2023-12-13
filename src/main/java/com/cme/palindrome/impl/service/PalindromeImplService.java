package com.cme.palindrome.impl.service;

import com.cme.palindrome.impl.PalindromeImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;

@Slf4j
@Service
public class PalindromeImplService implements PalindromeImpl {

        private final PalindromeCache palindromeCache = new PalindromeCache();
        private static final String CACHE_FILE_PATH = "cacheFile.csv";

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
                                        saveToPermanentCache(originalString);
                                        log.info("Added string " + originalString + " to the cache");
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
            try (BufferedReader reader = new BufferedReader(new FileReader(CACHE_FILE_PATH))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                                palindromeCache.addToCache(line);
                                log.info("Permanent cache contains :" + line);
                        }
                } catch (IOException e) {
                    log.error("Error loading permanent cache: " + e.getMessage());
                }
        }

        @Override
        public void saveToPermanentCache(String input) throws IOException {
                if (palindromeCache.isPalindromeCached(input)){
                    try(BufferedWriter br = new BufferedWriter(new FileWriter(CACHE_FILE_PATH, true))){
                                br.write(input + ",");
                                log.info(input + " has been saved to permanent cache");
                        }catch (IOException e){
                            log.error("Error saving to permanent cache: " + e.getMessage());
                            throw e;
                    }
                }
        }

}