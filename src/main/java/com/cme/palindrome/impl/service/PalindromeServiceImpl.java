package com.cme.palindrome.impl.service;

import com.cme.palindrome.impl.PalindromeImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;
@Slf4j
@Service
public class PalindromeServiceImpl implements PalindromeImpl {

    private final PalindromeCache palindromeCache = new PalindromeCache();
    private static final String CACHE_FILE_PATH = "cacheFile.csv";

    @Override
    public boolean palindromeChecker(String originalString) throws IOException {
        loadPermanentCache();

        if (isValidString(originalString)) {
            String lowerCaseString = originalString.toLowerCase();

            if (palindromeCache.isPalindromeCached(lowerCaseString)) {
                log.info("Input is a palindrome and was in the local cache: " + originalString);
                return true;
            } else {
                String reverseValue = new StringBuilder(lowerCaseString).reverse().toString();
                boolean isPalindromeCheck = lowerCaseString.equals(reverseValue);

                if (isPalindromeCheck) {
                    palindromeCache.addToCache(lowerCaseString);
                    saveToPermanentCache(lowerCaseString);
                    log.info("It is a Palindrome: " + lowerCaseString);
                    log.info("Added string " + lowerCaseString + " to the cache");
                } else {
                    log.error("Not a Palindrome " + lowerCaseString);
                }
                return isPalindromeCheck;
            }
        } else {
            log.error("String does not meet the correct format");
            return false;
        }
    }

    @Override
    public boolean isValidString(String originalString) {
        return !originalString.isEmpty() &&
                originalString.chars().noneMatch(Character::isSpaceChar) &&
                originalString.chars().noneMatch(Character::isDigit);
    }

    @Override
    public void loadPermanentCache() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CACHE_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                log.info("Permanent cache contains: " + line);
            }
        } catch (IOException e) {
            log.error("Error loading permanent cache: " + e.getMessage());
        }
    }

    @Override
    public void saveToPermanentCache(String input) throws IOException {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(CACHE_FILE_PATH, true))) {
            br.write(input + "\n");
            log.info(input + " has been saved to permanent cache");
        } catch (IOException e) {
            log.error("Error saving to permanent cache: " + e.getMessage());
            throw e;
        }
    }
}