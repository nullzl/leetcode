package com.nullzl.leetcode100;

public class LeetCode70 {

    public int climbStairs(int n) {
        int preNum1 = 1;
        int preNum2 = 2;
        if(n < 0 )
            return 0;
        if(0 == n || 1 == n || 2 == n)
            return n;
        for(int i = 3; i <= n ; i++){
            int temp = preNum1 + preNum2;
            preNum1 = preNum2;
            preNum2 = temp;
        }
        return preNum2;
    }
}
