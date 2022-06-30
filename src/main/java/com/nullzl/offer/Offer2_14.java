package com.nullzl.offer;

public class Offer2_14 {

    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length())
            return false;
        int[] map = new int[26];
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        for(char ch : arr1){
            map[ch - 'a']++;
        }
        int count = s1.length();
        int i = 0;
        for(i = 0 ; i < s2.length() ; i ++){
            if(--map[arr2[i] - 'a'] >= 0)
                count--;
            if(i - s1.length() >= 0 && ++map[arr2[i - s1.length()] - 'a'] > 0)
                count++;
            if(0 == count)
                return true;
        }
        return false;

    }
}
