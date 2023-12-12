package com.cme.palindrome.impl.service;

import java.util.ArrayList;

public class PalindromeCache {

    private final ArrayList<String> cache;

    // Initialize our cache
    public PalindromeCache(){
        this.cache = new ArrayList<>();
    }

    public boolean isPalindromeCached(String input){
        return cache.contains(input.toLowerCase());
    }

    public void addToCache(String input){
        cache.add(input.toLowerCase());
    }
}
