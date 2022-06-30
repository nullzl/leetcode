package com.nullzl.offer;

public class Offer2_32 {

    public boolean isAnagram(String s, String t) {

        if(s.equals(t) || s.length() != t.length())
            return false;
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        int[] map = new int[26];
        for(char ch : arr1){
            map[ch - 'a']++;
        }
        for(char ch : arr2){
            if(--map[ch - 'a'] < 0)
                return false;
        }
        return true;

    }
}
