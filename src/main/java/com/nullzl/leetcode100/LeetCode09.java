package com.nullzl.leetcode100;

public class LeetCode09 {

    public boolean isPalindrome(int x) {

        if(x < 0)
            return false;
        long rs = 0 ;
        int temp = x;
        while(0 != temp){
            rs = rs * 10 + temp % 10;
            temp = temp / 10;
        }
        if(rs == x)
            return true;
        return false;

    }
}
