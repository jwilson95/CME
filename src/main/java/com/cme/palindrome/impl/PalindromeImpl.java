package com.cme.palindrome.impl;

import java.io.IOException;

public interface PalindromeImpl {

    boolean palindromeChecker(String input) throws IOException;
    boolean isValidString(String input);
    void loadPermanentCache();
    void saveToPermanentCache(String input) throws IOException;
}
