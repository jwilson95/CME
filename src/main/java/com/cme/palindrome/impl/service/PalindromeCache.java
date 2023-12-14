package com.cme.palindrome.impl.service;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@ToString
public class PalindromeCache {

    private final List<String> cache;

    // Initialize our cache
    public PalindromeCache(){
        this.cache = new ArrayList<>();
    }

    public boolean isPalindromeCached(String input){
        return cache.contains(input);
    }

    public void addToCache(String input){
        cache.add(input);
    }

    public void printCahce(){
        log.info("Local cache contains: " + cache);
    }

}
