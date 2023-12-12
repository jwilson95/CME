package Impl.Service;

import java.util.ArrayList;

public class PalindromeCache {

    private final ArrayList<String> cache;

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
}
