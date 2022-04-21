package com.nullzl.offer;

import java.util.HashMap;

public class Offer50 {

    public char firstUniqChar(String s) {

        if(null == s || 0 == s.length())
            return ' ';
        HashMap<Character,Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for(int i = 0; i < s.length() ; i++){
            int count = map.getOrDefault(arr[i],0);
            map.put(arr[i],count + 1);
        }

        for(int i = 0 ; i < s.length(); i++){
            if(1 == map.get(arr[i]))
                return arr[i];
        }

        return ' ';

    }
}
