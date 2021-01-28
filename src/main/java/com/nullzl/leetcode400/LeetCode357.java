package com.nullzl.leetcode400;

public class LeetCode357 {

    public int countNumbersWithUniqueDigits(int n) {

        if(0 == n)
            return 1;
        int sum = 10;
        int tmp = 9;
        int min = Math.min(n,10);
        for(int i = 2; i <= min; i++){
            tmp *= (11 - i);
            sum += tmp;
        }
        return sum;

    }
}
