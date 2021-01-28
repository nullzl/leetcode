package com.nullzl.leetcode300;

public class LeetCode258 {

    public int addDigits(int num) {
        if(num < 0)
            throw new IllegalArgumentException();
        if(0 == num)
            return 0;
        int rs = num % 9 ;
        return 0 == rs ? 9 : rs;

    }
}
