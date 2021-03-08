package com.nullzl.leetcode400;

public class LeetCode344 {

    public void reverseString(char[] s) {

        if(null == s)
            return;
        char temp;
        for(int i = 0,j=s.length - 1; i < j; i++,j--){
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }

    }
}
