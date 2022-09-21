package com.nullzl.leetcode900;

public class LeetCode829 {

    public int consecutiveNumbersSum(int n) {
        int count = 0;
        int k = 1;
        int sum = 1;
        while(sum <= n){
            if(0 == (n - sum) % k)
                count++;
            sum += (++k);
        }
        return count;
    }
}
