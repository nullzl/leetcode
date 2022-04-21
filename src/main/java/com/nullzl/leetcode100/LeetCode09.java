package com.nullzl.leetcode100;

public class LeetCode09 {

    public boolean isPalindrome1(int x) {

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
    public boolean isPalindrome(int x) {
        int y = 0;
        while(x > y){
            int t = x % 10;
            y = y * 10 + x % 10;
            x /= 10;
        }
        return x == y || y / 10 == x;
    }
}
