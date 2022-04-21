package com.nullzl.leetcode100;

public class LeetCode50 {

    public double myPow(double x, int n) {
        boolean neg = false;
        long m = n;
        if(m < 0){
            x = 1 / x;
            m = Math.abs(m);
        }
        double ans = 1;
        double num = x;
        while(m != 0){
            if(0 != (1 & m)) {
                ans *= num;
            }
            m >>>= 1;
            num *= num;
        }
        return ans;
    }
}
