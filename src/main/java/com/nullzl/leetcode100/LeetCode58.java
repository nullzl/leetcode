package com.nullzl.leetcode100;

public class LeetCode58 {

    public int lengthOfLastWord(String s) {

        if(null == s)
            return 0;
        int i,j;
        for(i = s.length() - 1 ; i >=0 && ' ' == s.charAt(i); i--);
        for(j = i ; j >=0 && ' ' != s.charAt(j) ; j--);
        return i - j;

    }
}
