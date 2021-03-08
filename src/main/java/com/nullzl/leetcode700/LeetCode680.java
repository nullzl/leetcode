package com.nullzl.leetcode700;

public class LeetCode680 {

    public boolean validPalindrome(String s) {
        if(null == s)
            return false;
        if(0 == s.length() || 1 == s.length())
            return true;

        int i,j,x,y;
        for(i = 0, j = s.length() -1 ; i < j ; i++,j--){
            if(s.charAt(i) != s.charAt(j))
                break;
        }
        if(i >= j)
            return true;

        for(x = i + 1,y = j ; x < y ; x++,y--){
            if(s.charAt(x) != s.charAt(y))
                break;
        }
        if(x >= y)
            return true;
        for(x = i,y = j -1; x < y ; x++,y--){
            if(s.charAt(x) != s.charAt(y))
                break;
        }
        if(x >= y)
            return true;
        return false;
    }
    public static void main(String[] args){
        System.out.println(new LeetCode680().validPalindrome("aaaaaaabaaaaaaaaaaaba"));
    }
}
