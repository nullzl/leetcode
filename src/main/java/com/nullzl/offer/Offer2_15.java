package com.nullzl.offer;

import java.util.ArrayList;
import java.util.List;

public class Offer2_15 {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> list = new ArrayList<>();
        if(s.length() < p.length())
            return list;
        int count = p.length();
        int[] map = new int[26];
        char[] arr1 = s.toCharArray();
        char[] arr2 = p.toCharArray();
        for(char ch : arr2){
            map[ch - 'a']++;
        }
        for(int i = 0 ; i < arr1.length ; i++){
            if(i - arr2.length >= 0 && ++map[arr1[i - arr2.length] - 'a'] > 0)
                count++;
            if(--map[arr1[i] - 'a'] >= 0)
                count--;
            if (0 == count) {
                list.add(i - arr2.length + 1);
            }
        }
        return list;

    }
}
