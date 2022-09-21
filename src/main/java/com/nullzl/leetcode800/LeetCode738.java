package com.nullzl.leetcode800;

public class LeetCode738 {
    public int monotoneIncreasingDigits(int n) {
        int prev = -1 , times = -1;
        int left = n / 10 , right = n % 10 ;
        int k = 10;
        while(0 != left){
            int t = left % 10;
            if(t >right){
                prev = left;
                times = k;
            }
            k *= 10;
            right = t;
            left /= 10;
        }
        return -1 == prev ? n : monotoneIncreasingDigits(prev - 1) * times + times - 1;
    }
}
