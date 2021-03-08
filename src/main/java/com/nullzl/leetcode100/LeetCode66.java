package com.nullzl.leetcode100;

public class LeetCode66 {

    public int[] plusOne(int[] digits) {

        if(null == digits || 0 == digits.length)
            return null;

        int i;
        for(i= digits.length - 1 ; i >= 0 ; i--){
            if(9 == digits[i]){
                digits[i] = 0;
            }else{
                digits[i]++;
                break;
            }
        }
        if(-1 == i){
            int[] rs = new int[digits.length + 1];
            rs[0] = 1;
            return rs;
        }
        return digits;

    }
}
