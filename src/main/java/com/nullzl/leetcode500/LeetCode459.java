package com.nullzl.leetcode500;

public class LeetCode459 {

    public boolean repeatedSubstringPattern(String s) {

        if(null == s || 0 == s.length())
            return false;
        char[] arr = s.toCharArray();
        for(int k = 1 ; k < s.length() ; k++){
            if(0 != s.length() % k)
                continue;
            int i = k;
            for(; i < arr.length && arr[i] == arr[i % k] ; i++);
            if(i == arr.length)
                return true;
        }
        return false;
    }
}
