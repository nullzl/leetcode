package com.nullzl.leetcode400;

public class LeetCode400 {

    public int findNthDigit(int n) {

        int k = 1;
        long num = 1;
        while(true){
            long count = 9 * num * k;
            if(n <= count)
                break;
            n -= count;
            k++;
            num *= 10;
        }
        n--;
        num += (n / k);
        return String.valueOf(num).toCharArray()[n % k] - '0';

    }
}
