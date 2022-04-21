package com.nullzl.interview;

import java.util.HashMap;

public class Interview0102 {

    public boolean CheckPermutation(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0 ; i < arr1.length ; i++){
            int count = map.getOrDefault(arr1[i],0);
            map.put(arr1[i],count + 1);
        }
        for(int i = 0 ; i < arr2.length ; i++){
            int count = map.getOrDefault(arr2[i],0);
            if(0 == count)
                return false;
            map.put(arr2[i],count - 1);
        }
        return true;

    }
}
